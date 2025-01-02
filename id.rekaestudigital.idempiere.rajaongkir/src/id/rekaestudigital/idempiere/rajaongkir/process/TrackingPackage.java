package id.rekaestudigital.idempiere.rajaongkir.process;

import java.util.Map;

import org.adempiere.base.annotation.Process;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import id.rekaestudigital.idempiere.rajaongkir.model.RajaOngkir;

@Process(name = "id.rekaestudigital.idempiere.rajaongkir.process.TrackingPackage")
public class TrackingPackage extends SvrProcess {

	private int RO_Courier_ID = 0;
	private String Waybill = null;
	
	@Override
	protected void prepare() {
		for (ProcessInfoParameter p : getParameter()) {
			if (p.getParameterName().equals("RO_Courier_ID")) {
				RO_Courier_ID = p.getParameterAsInt();
			} else if (p.getParameterName().equals("Waybill")) {
            	Waybill = p.getParameter().toString();
            }
		}
	}

	@Override
	protected String doIt() throws Exception {
		RajaOngkir rajaongkir = new RajaOngkir();
		if(!RajaOngkir.ACCOUNT_TYPE_PRO.equals(rajaongkir.getAccountType())) {
			throw new AdempiereException("This process only available for Pro account");
		}
		JsonObject response = rajaongkir.waybill(RO_Courier_ID, Waybill);
		JsonObject status = response.get("status").getAsJsonObject();
		StringBuffer msg = new StringBuffer("<br/>");
		if (status.get("code").getAsInt() == 200) {
			JsonObject result = response.get("result").getAsJsonObject();
			msg.append("Delivered : " + result.get("delivered").getAsString() + "<br/>");
			
			JsonObject summary = result.get("summary").getAsJsonObject();
            msg.append("Summary : <br/>");
			for (Map.Entry<String, JsonElement> entry : summary.entrySet()) {
	            msg.append(entry.getKey() + ": " + entry.getValue() + "<br/>");
	        }
			
			JsonObject details = result.get("details").getAsJsonObject();
            msg.append("Detail : <br/>");
			for (Map.Entry<String, JsonElement> entry : details.entrySet()) {
	            msg.append(entry.getKey() + ": " + entry.getValue() + "<br/>");
	        }
			
			JsonObject delivery_status = result.get("delivery_status").getAsJsonObject();
            msg.append("Deliver Status : <br/>");
			for (Map.Entry<String, JsonElement> entry : delivery_status.entrySet()) {
	            msg.append(entry.getKey() + ": " + entry.getValue() + "<br/>");
	        }
			
			if(result.has("manifest")) {
				JsonArray manifests = result.get("manifest").getAsJsonArray();
				for(int i = 0; i < manifests.size(); i++) {
                    JsonObject manifest = manifests.get(i).getAsJsonObject();
                    addLog(manifest.get("manifest_description").getAsString() + " - " + manifest.get("manifest_date").getAsString() + " " + manifest.get("manifest_time").getAsString() + " : " + manifest.get("city_name").getAsString());
				}
			}
		} else {
			throw new AdempiereException(status.get("description").getAsString());
		}
		return msg.toString();
	}

}
