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
public class CheckInternationalCost extends SvrProcess {

	private int C_City_Origin_ID = 0;
	private int RO_InternationalDestination_ID = 0;
	private int RO_Courier_ID = 0;
	private BigDecimal weight;
	private BigDecimal width;
	private BigDecimal length;
	private BigDecimal height;

	@Override
	protected void prepare() {
		for (ProcessInfoParameter p : getParameter()) {
            if (p.getParameterName().equals("C_City_Origin_ID")) {
            	C_City_Origin_ID = p.getParameterAsInt();
			} else if (p.getParameterName().equals("RO_InternationalDestination_ID")) {
				RO_InternationalDestination_ID = p.getParameterAsInt();
			} else if (p.getParameterName().equals("RO_Courier_ID")) {
				RO_Courier_ID = p.getParameterAsInt();
			} else if (p.getParameterName().equals("Weight")) {
				weight = p.getParameterAsBigDecimal();
			} else if (p.getParameterName().equals("Width")) {
				width = p.getParameterAsBigDecimal();
			} else if (p.getParameterName().equals("Height")) {
				height = p.getParameterAsBigDecimal();
			} else if (p.getParameterName().equals("Length")) {
				length = p.getParameterAsBigDecimal();
			}
        }
	}

	@Override
	protected String doIt() throws Exception {
		RajaOngkir rajaongkir = new RajaOngkir();
		if(!RajaOngkir.ACCOUNT_TYPE_PRO.equals(rajaongkir.getAccountType())) {
			throw new AdempiereException("This process only available for Pro account");
		}
		JsonObject result = null;
		StringBuffer msg = new StringBuffer("<br/>");
		result = rajaongkir.getInternationalCosts(C_City_Origin_ID, RO_InternationalDestination_ID, RO_Courier_ID, weight, width, length, height);
		JsonObject status = result.get("status").getAsJsonObject();
		if (status.get("code").getAsInt() == 200) {
			JsonObject origin = result.get("origin_details").getAsJsonObject();
            msg.append("From : "+ origin.get("city_name").getAsString() + " - " + origin.get("province").getAsString() + "<br/>");

			JsonObject destination = result.get("destination_details").getAsJsonObject();
            msg.append("To : "+ destination.get("country_name").getAsString() + "<br/>");
			
			JsonArray results = result.get("results").getAsJsonArray();
			for (int i = 0; i < results.size(); i++) {
				JsonObject cost = results.get(i).getAsJsonObject();
				msg.append("Courier : " + cost.get("name").getAsString() + "<br/><br/>");
				JsonArray costs = cost.get("costs").getAsJsonArray();
				for (int j = 0; j < costs.size(); j++) {
					JsonObject costDetail = costs.get(j).getAsJsonObject();
					msg.append(costDetail.get("service").getAsString()  
							+ " : " + costDetail.get("currency").getAsString()
							+ " " + costDetail.get("cost").getAsBigDecimal()
							+ ". ETD : " + costDetail.get("etd").getAsString()
							+ "<br/>");
				}
			}
		} else {
			throw new AdempiereException(status.get("description").getAsString());
		}
		return msg.toString();
	}

}
