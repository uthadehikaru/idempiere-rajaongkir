/**
 * 
 */
package id.rekaestudigital.idempiere.rajaongkir.model;

import java.sql.ResultSet;
import java.util.Properties;

@org.adempiere.base.Model(table = "RO_InternationalDestination")
public class MInternationalDestination extends X_RO_InternationalDestination {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4941636177771499218L;

	public MInternationalDestination(Properties ctx, int RO_InternationalDestination_ID, String trxName) {
		super(ctx, RO_InternationalDestination_ID, trxName);
	}
	
	public MInternationalDestination(Properties ctx, int RO_InternationalDestination_ID, String trxName, String[] virtualColumns) {
		super(ctx, RO_InternationalDestination_ID, trxName, virtualColumns);
	}
	
	public MInternationalDestination(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

}
