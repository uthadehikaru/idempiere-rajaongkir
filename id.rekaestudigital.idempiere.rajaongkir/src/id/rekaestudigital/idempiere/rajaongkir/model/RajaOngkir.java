package id.rekaestudigital.idempiere.rajaongkir.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.compiere.model.MCity;
import org.compiere.model.MSysConfig;
import org.compiere.util.Env;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class RajaOngkir {

	public static final String RAJAONGKIR_ACCOUNT_TYPE = "RAJAONGKIR_ACCOUNT_TYPE";
	public static final String RAJAONGKIR_ENDPOINT_STARTER = "RAJAONGKIR_ENDPOINT_STARTER";
	public static final String RAJAONGKIR_ENDPOINT_PRO = "RAJAONGKIR_ENDPOINT_PRO";
	public static final String RAJAONGKIR_API_KEY = "RAJAONGKIR_API_KEY";
	public static final String ACCOUNT_TYPE_PRO = "pro";
	public static final String ACCOUNT_TYPE_STARTER = "starter";
	
	private String accountType;
	private String endpoint;
	private String apiKey;
	
	public RajaOngkir() {
		accountType = MSysConfig.getValue(RajaOngkir.RAJAONGKIR_ACCOUNT_TYPE, "starter");
		if(accountType.equals("pro")) {
			endpoint = MSysConfig.getValue(RajaOngkir.RAJAONGKIR_ENDPOINT_PRO, "https://pro.rajaongkir.com/api");
		} else {
			endpoint = MSysConfig.getValue(RajaOngkir.RAJAONGKIR_ENDPOINT_STARTER, "https://api.rajaongkir.com/starter");
		}
		apiKey = MSysConfig.getValue(RajaOngkir.RAJAONGKIR_API_KEY, null);
    }
	
	private JsonObject sendRequest(String url) {
		return sendRequest(url, "GET", null);
	}
	
	private JsonObject sendRequest(String url, String method, String parameters) {
		if(apiKey == null) {
			throw new IllegalArgumentException(RajaOngkir.RAJAONGKIR_API_KEY + " SysConfig is required");
		}
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// Optional default is GET
			con.setRequestMethod(method);

			// Add request header
			con.setRequestProperty("key", this.apiKey);
			
			
			if (parameters != null) {
				con.setDoOutput(true);
				// Write form data to the output stream
	            try (OutputStream os = con.getOutputStream()) {
	                byte[] input = parameters.toString().getBytes(StandardCharsets.UTF_8);
	                os.write(input, 0, input.length);
	            }
			}

			int responseCode = con.getResponseCode();

			BufferedReader in;
			if (responseCode == 200) {
				in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { 
				in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// Print result
			JsonObject result = new Gson().fromJson(response.toString(), JsonObject.class);
			if (result.has("rajaongkir")) {
				return result.get("rajaongkir").getAsJsonObject();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getAccountType() {
		return accountType;
	}
		
	public JsonObject getProvinces() {
		return sendRequest(this.endpoint + "/province");
    }
	
	public JsonObject getCities() {
		return sendRequest(this.endpoint + "/city");
    }
	
	public JsonObject getSubDistricts(int cityId) {
		return sendRequest(this.endpoint + "/subdistrict?city=" + cityId);
    }
	
	public JsonObject getCosts(int c_City_Origin_ID, int c_City_Destination_ID, int ro_Courier_ID, BigDecimal weight) {
		return getCosts(c_City_Origin_ID, 0, c_City_Destination_ID, 0, ro_Courier_ID, weight, null, null, null, null);
	}

	public JsonObject getCosts(int c_City_Origin_ID, int c_Subdistrict_Origin_ID, int c_City_Destination_ID, int c_Subdistrict_Destination_ID, int rO_Courier_ID, BigDecimal weight, BigDecimal width, BigDecimal length, BigDecimal height, BigDecimal diameter) {
		MCity cityOrigin = new MCity(Env.getCtx(), c_City_Origin_ID, null);
		MCity cityDestination = new MCity(Env.getCtx(), c_City_Origin_ID, null);
		MSubdistrict subdistrictOrigin = null;
		MSubdistrict subdistrictDestination = null;
		MCourier courier = new MCourier(Env.getCtx(), rO_Courier_ID, null);
		if(c_Subdistrict_Origin_ID > 0) {
			subdistrictOrigin = new MSubdistrict(Env.getCtx(), c_Subdistrict_Origin_ID, null);
		}
		if(c_Subdistrict_Destination_ID > 0) {
			subdistrictDestination = new MSubdistrict(Env.getCtx(), c_Subdistrict_Destination_ID, null);
		}
        
        // Form data to send in the POST request
        StringBuffer parameters = new StringBuffer();
        parameters.append("courier=" + courier.getValue());
        if(RajaOngkir.ACCOUNT_TYPE_PRO.equals(getAccountType())) {
			parameters.append("&originType=" + (c_Subdistrict_Origin_ID > 0 ? "subdistrict" : "city"));
			parameters.append("&destinationType=" + (c_Subdistrict_Destination_ID > 0 ? "subdistrict" : "city"));
			if (c_Subdistrict_Origin_ID > 0) {
				parameters.append("&origin=" + subdistrictOrigin.getRO_Subdistrict_ID());
			}else {
				parameters.append("&origin=" + cityOrigin.get_ValueAsInt("RO_City_ID"));
			}
			if (c_Subdistrict_Destination_ID > 0) {
				parameters.append("&destination=" + subdistrictDestination.getRO_Subdistrict_ID());
			}else {
				parameters.append("&destination=" + cityDestination.get_ValueAsInt("RO_City_ID"));
			}
			if(width != null) {
                parameters.append("&width=" + width);
            }
			if(height != null) {
                parameters.append("&height=" + height);
            }
			if(length != null) {
                parameters.append("&length=" + length);
            }
			if(diameter != null) {
                parameters.append("&diameter=" + diameter);
            }
        }else {
            parameters.append("&origin=" + c_City_Origin_ID);
            parameters.append("&destination=" + c_City_Destination_ID);
        }
        parameters.append("&weight=" + weight);
        
        return sendRequest(this.endpoint + "/cost", "POST", parameters.toString());     
	}

	public JsonObject getInternationalCosts(int c_City_Origin_ID, int ro_InternationalDestination_ID, int rO_Courier_ID, BigDecimal weight, BigDecimal width, BigDecimal length, BigDecimal height) {
		MCity cityOrigin = new MCity(Env.getCtx(), c_City_Origin_ID, null);
		MCourier courier = new MCourier(Env.getCtx(), rO_Courier_ID, null);
		
        // Form data to send in the POST request
        StringBuffer parameters = new StringBuffer();
        parameters.append("courier=" + courier.getValue());
        parameters.append("&origin=" + cityOrigin.get_ValueAsInt("RO_City_ID"));
		parameters.append("&destination=" + ro_InternationalDestination_ID);
		if(width != null) {
            parameters.append("&width=" + width);
        }
		if(height != null) {
            parameters.append("&height=" + height);
        }
		if(length != null) {
            parameters.append("&length=" + length);
        }
        parameters.append("&weight=" + weight);
        
        return sendRequest(this.endpoint + "/v2/internationalCost", "POST", parameters.toString());     
	}

	public JsonObject getInternationalOrigin() {
        return sendRequest(this.endpoint + "/v2/internationalOrigin");
	}

	public JsonObject getInternationalDestination() {
        return sendRequest(this.endpoint + "/v2/internationalDestination");
	}

	public JsonObject waybill(int rO_Courier_ID, String waybill) {
		MCourier courier = new MCourier(Env.getCtx(), rO_Courier_ID, null);

		// Form data to send in the POST request
		StringBuffer parameters = new StringBuffer();
        parameters.append("courier=" + courier.getValue());
        parameters.append("&waybill=" + waybill);
        
        return sendRequest(this.endpoint + "/waybill", "POST", parameters.toString());
	}

}
