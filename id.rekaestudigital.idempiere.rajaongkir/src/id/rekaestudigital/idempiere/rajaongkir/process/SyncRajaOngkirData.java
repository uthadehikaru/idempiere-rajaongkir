package id.rekaestudigital.idempiere.rajaongkir.process;

import org.adempiere.base.annotation.Process;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MCity;
import org.compiere.model.MRegion;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import id.rekaestudigital.idempiere.rajaongkir.model.MInternationalDestination;
import id.rekaestudigital.idempiere.rajaongkir.model.MSubdistrict;
import id.rekaestudigital.idempiere.rajaongkir.model.RajaOngkir;

@Process(name = "id.rekaestudigital.idempiere.rajaongkir.process.SyncRajaOngkirData")
public class SyncRajaOngkirData extends SvrProcess {

	private int C_Country_ID = 0;

	@Override
	protected void prepare() {
		for (ProcessInfoParameter p : getParameter()) {
            if (p.getParameterName().equals("C_Country_ID")) {
                C_Country_ID = p.getParameterAsInt();
            }
        }
	}

	@Override
	protected String doIt() throws Exception {
		RajaOngkir rajaongkir = new RajaOngkir();
        JsonObject dataProvinces = rajaongkir.getProvinces();
		JsonObject status = dataProvinces.get("status").getAsJsonObject();
		if (status.get("code").getAsInt() == 200) {
			JsonObject dataCities = rajaongkir.getCities();
			status = dataCities.get("status").getAsJsonObject();
			JsonArray cities = new JsonArray();
			if (status.get("code").getAsInt() == 200) {
				cities = dataCities.get("results").getAsJsonArray();
			} else {
				throw new AdempiereException(status.get("description").getAsString());
			}
			JsonArray provinces = dataProvinces.get("results").getAsJsonArray();
			for(int i = 0; i < provinces.size(); i++) {
                JsonObject province = provinces.get(i).getAsJsonObject();
				statusUpdate("Processing Provinces : " + i + " of " + provinces.size() + " - " + province.get("province").getAsString());
				MRegion region = new Query(getCtx(), MRegion.Table_Name, "C_Country_ID=? AND Name = ?", get_TrxName())
						.setParameters(C_Country_ID, province.get("province").getAsString()).first();
				if (region == null) {
					region = new MRegion(getCtx(), 0, get_TrxName());
                    region.setC_Country_ID(C_Country_ID);
                    region.setName(province.get("province").getAsString());
				}
                region.set_ValueOfColumn("RO_Province_ID", province.get("province_id").getAsInt());
                region.save();
				addLog("Province : " + province.get("province").getAsString());
				
				for(int j = 0; j < cities.size(); j++) {
					JsonObject dataCity = cities.get(j).getAsJsonObject();
					if (dataCity.get("province_id").getAsInt() != province.get("province_id").getAsInt()) {
						continue;
					}
					MCity city = new Query(getCtx(), MCity.Table_Name, "C_Region_ID=? AND Name = ?", get_TrxName())
							.setParameters(region.getC_Region_ID(), dataCity.get("city_name").getAsString()).first();
					if (city == null) {
						city = new MCity(getCtx(), 0, get_TrxName());
						city.setC_Country_ID(C_Country_ID);
						city.setC_Region_ID(region.getC_Region_ID());
						city.setName(dataCity.get("city_name").getAsString());
					}
					city.set_ValueOfColumn("RO_City_ID", dataCity.get("city_id").getAsString());
					city.setPostal(dataCity.get("postal_code").getAsString());
					city.save();
					addLog("City : " + dataCity.get("city_name").getAsString());
					
					if(RajaOngkir.ACCOUNT_TYPE_PRO.equals(rajaongkir.getAccountType())) {
						JsonObject dataSubdistricts = rajaongkir.getSubDistricts(dataCity.get("city_id").getAsInt());
                        status = dataSubdistricts.get("status").getAsJsonObject();
                        JsonArray subdistricts = new JsonArray();
                        if (status.get("code").getAsInt() == 200) {
                            subdistricts = dataSubdistricts.get("results").getAsJsonArray();
                        } else {
                            throw new AdempiereException(status.get("description").getAsString());
                        }
                        for(int k = 0; k < subdistricts.size(); k++) {
                            JsonObject dataSubdistrict = subdistricts.get(k).getAsJsonObject();
                            MSubdistrict subdistrict = new Query(getCtx(), MSubdistrict.Table_Name, "C_City_ID=? AND Name=?", get_TrxName())
                                    .setParameters(city.getC_City_ID(), dataSubdistrict.get("subdistrict_name").getAsString()).first();
                            if (subdistrict == null) {
                            	subdistrict = new MSubdistrict(getCtx(), 0, get_TrxName());
                            	subdistrict.setRO_Subdistrict_ID(dataSubdistrict.get("subdistrict_id").getAsInt());
                                subdistrict.setC_City_ID(city.getC_City_ID());
                                subdistrict.setName(dataSubdistrict.get("subdistrict_name").getAsString());
                            }
                            subdistrict.setRO_Subdistrict_Type(dataSubdistrict.get("type").getAsString());
                            subdistrict.save();
                            addLog("Subdistrict : " + dataSubdistrict.get("subdistrict_name").getAsString());
                        }
					}	
				}
				commitEx();
           }
		} else {
			throw new AdempiereException(status.get("description").getAsString());
		}
		
		if(RajaOngkir.ACCOUNT_TYPE_PRO.equals(rajaongkir.getAccountType())) {
			JsonObject dataInternationalOrigins = rajaongkir.getInternationalOrigin();
			status = dataInternationalOrigins.get("status").getAsJsonObject();
			if(status.get("code").getAsInt() == 200) {
				addLog("International Origins");
                JsonArray internationalOrigins = dataInternationalOrigins.get("results").getAsJsonArray();
                for(int i = 0; i < internationalOrigins.size(); i++) {
                    JsonObject internationalOrigin = internationalOrigins.get(i).getAsJsonObject();
                    statusUpdate("Processing International Origin : " + i + " of " + internationalOrigins.size() + " - " + internationalOrigin.get("city_name").getAsString());
                    MCity city = new Query(getCtx(), MCity.Table_Name, "RO_City_ID=?", get_TrxName())
                            .setParameters(internationalOrigin.get("city_id").getAsInt()).first();
                    if (city != null) {
                    	city.set_ValueOfColumn("IsInternationalOrigin", true);
                    	city.saveEx();
                    }
                    addLog(internationalOrigin.get("city_name").getAsString());
                }
            } else {
                throw new AdempiereException(status.get("description").getAsString());
            }
			commitEx();
			
			JsonObject dataInternationalDestinations = rajaongkir.getInternationalDestination();
			status = dataInternationalDestinations.get("status").getAsJsonObject();
			if(status.get("code").getAsInt() == 200) {
				addLog("International Destinations");
                JsonArray internationalDestinations = dataInternationalDestinations.get("results").getAsJsonArray();
                for(int i = 0; i < internationalDestinations.size(); i++) {
                    JsonObject internationalDestination = internationalDestinations.get(i).getAsJsonObject();
                    statusUpdate("Processing International Destinations : " + i + " of " + internationalDestinations.size() + " - " + internationalDestination.get("country_name").getAsString());
                    MInternationalDestination country = new Query(getCtx(), MInternationalDestination.Table_Name, MInternationalDestination.COLUMNNAME_RO_InternationalDestination_ID+"=?", get_TrxName())
                            .setParameters(internationalDestination.get("country_id").getAsInt()).first();
                    if (country == null) {
						country = new MInternationalDestination(getCtx(), 0, get_TrxName());
						country.setRO_InternationalDestination_ID(internationalDestination.get("country_id").getAsInt());
						country.setName(internationalDestination.get("country_name").getAsString());
	                	country.saveEx();
                    }
                	
                    addLog(internationalDestination.get("country_name").getAsString());
                }
            } else {
                throw new AdempiereException(status.get("description").getAsString());
            }
		}
		return "success";
	}

}
