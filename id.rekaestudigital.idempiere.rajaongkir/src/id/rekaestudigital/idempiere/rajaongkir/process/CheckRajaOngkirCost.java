package id.rekaestudigital.idempiere.rajaongkir.process;

import java.math.BigDecimal;

import org.adempiere.base.annotation.Process;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import id.rekaestudigital.idempiere.rajaongkir.model.RajaOngkir;

@Process(name = "id.rekaestudigital.idempiere.rajaongkir.process.CheckRajaOngkirCost")
public class CheckRajaOngkirCost extends SvrProcess {

	private int C_City_Origin_ID = 0;
	private int RO_Subdistrict_Origin_ID = 0;
	private int C_City_Destination_ID = 0;
	private int RO_Subdistrict_Destination_ID = 0;
	private int RO_Courier_ID = 0;
	private BigDecimal weight;
	private BigDecimal width;
	private BigDecimal length;
	private BigDecimal height;
	private BigDecimal diameter;

	@Override
	protected void prepare() {
		for (ProcessInfoParameter p : getParameter()) {
            if (p.getParameterName().equals("C_City_Origin_ID")) {
            	C_City_Origin_ID = p.getParameterAsInt();
			} else if (p.getParameterName().equals("RO_Subdistrict_Origin_ID")) {
				RO_Subdistrict_Origin_ID = p.getParameterAsInt();
			} else if (p.getParameterName().equals("C_City_Destination_ID")) {
				C_City_Destination_ID = p.getParameterAsInt();
			} else if (p.getParameterName().equals("RO_Subdistrict_Destination_ID")) {
				RO_Subdistrict_Destination_ID = p.getParameterAsInt();
			}  else if (p.getParameterName().equals("RO_Courier_ID")) {
				RO_Courier_ID = p.getParameterAsInt();
			} else if (p.getParameterName().equals("Weight")) {
				weight = p.getParameterAsBigDecimal();
			} else if (p.getParameterName().equals("Width")) {
				width = p.getParameterAsBigDecimal();
			} else if (p.getParameterName().equals("Height")) {
				height = p.getParameterAsBigDecimal();
			} else if (p.getParameterName().equals("Length")) {
				length = p.getParameterAsBigDecimal();
			} else if (p.getParameterName().equals("Diameter")) {
				diameter = p.getParameterAsBigDecimal();
			}
        }
	}

	@Override
	protected String doIt() throws Exception {
		RajaOngkir rajaongkir = new RajaOngkir();
		JsonObject result = null;
		StringBuffer msg = new StringBuffer("<br/>");
		if(RajaOngkir.ACCOUNT_TYPE_PRO.equals(rajaongkir.getAccountType())) {
			result = rajaongkir.getCosts(C_City_Origin_ID, RO_Subdistrict_Origin_ID, C_City_Destination_ID, RO_Subdistrict_Destination_ID, RO_Courier_ID, weight, width, length, height, diameter);
		}else {
			result = rajaongkir.getCosts(C_City_Origin_ID, C_City_Destination_ID, RO_Courier_ID, weight);
		}
		JsonObject status = result.get("status").getAsJsonObject();
		if (status.get("code").getAsInt() == 200) {
			if(result.get("origin_details").isJsonObject()) {
				JsonObject origin = result.get("origin_details").getAsJsonObject();
	            msg.append("From : "+ origin.get("city").getAsString() + " - " + origin.get("province").getAsString() + "<br/>");
			}

			if(result.get("destination_details").isJsonObject()) {
				JsonObject destination = result.get("destination_details").getAsJsonObject();
	            msg.append("To : "+ destination.get("city").getAsString() + " - " + destination.get("province").getAsString() + "<br/>");
			}
			
			JsonArray results = result.get("results").getAsJsonArray();
			for (int i = 0; i < results.size(); i++) {
				JsonObject cost = results.get(i).getAsJsonObject();
				msg.append("Courier : " + cost.get("name").getAsString() + "<br/><br/>");
				JsonArray costs = cost.get("costs").getAsJsonArray();
				for (int j = 0; j < costs.size(); j++) {
					JsonObject costDetail = costs.get(j).getAsJsonObject();
					msg.append(costDetail.get("service").getAsString());
					JsonArray costDetailCosts = costDetail.get("cost").getAsJsonArray();
					for (int k = 0; k < costDetailCosts.size(); k++) {
						JsonObject costDetailCost = costDetailCosts.get(k).getAsJsonObject();
						msg.append(" : " + costDetailCost.get("value").getAsBigDecimal());
						msg.append(". ETD " + costDetailCost.get("etd").getAsString());
						if(costDetailCost.has("note") && costDetailCost.get("note").getAsString().length() > 0) {
                            msg.append(" (" + costDetailCost.get("note").getAsString() + ")");
						}
					}
					msg.append("<br/>");
				}
			}
		} else {
			throw new AdempiereException(status.get("description").getAsString());
		}
		return msg.toString();
	}

}
