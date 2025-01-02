/**
 * 
 */
package id.rekaestudigital.idempiere.rajaongkir.model;

import java.sql.ResultSet;
import java.util.Properties;

@org.adempiere.base.Model(table = "RO_Courier")
public class MCourier extends X_RO_Courier {


	/**
	 * 
	 */
	private static final long serialVersionUID = 8981024459310160663L;

	public MCourier(Properties ctx, int RO_Courier_ID, String trxName) {
		super(ctx, RO_Courier_ID, trxName);
	}
	
	public MCourier(Properties ctx, int RO_Courier_ID, String trxName, String[] virtualColumns) {
		super(ctx, RO_Courier_ID, trxName, virtualColumns);
	}
	
	public MCourier(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

}
