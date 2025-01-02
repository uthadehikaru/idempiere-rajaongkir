/**
 * 
 */
package id.rekaestudigital.idempiere.rajaongkir.model;

import java.sql.ResultSet;
import java.util.Properties;

@org.adempiere.base.Model(table = "RO_Subdistrict")
public class MSubdistrict extends X_RO_Subdistrict {

	private static final long serialVersionUID = -7446101332822415154L;

	public MSubdistrict(Properties ctx, int RO_Subdistrict_ID, String trxName) {
		super(ctx, RO_Subdistrict_ID, trxName);
	}
	
	public MSubdistrict(Properties ctx, int RO_Subdistrict_ID, String trxName, String[] virtualColumns) {
		super(ctx, RO_Subdistrict_ID, trxName, virtualColumns);
	}
	
	public MSubdistrict(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

}
