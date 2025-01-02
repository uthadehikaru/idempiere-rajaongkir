package id.rekaestudigital.idempiere.rajaongkir.component;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.compiere.model.MSysConfig;
import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.osgi.service.event.Event;

import id.rekaestudigital.idempiere.rajaongkir.model.RajaOngkir;

public class RajaOngkirEventHandler extends AbstractEventHandler {

	private static CLogger log = CLogger.getCLogger(RajaOngkirEventHandler.class);
	
	@Override
	protected void initialize() {
		log.info("RajaOngkir Event Handler Initialized");

		registerEvent(IEventTopics.AFTER_LOGIN);
	}
	
	@Override
	protected void doHandleEvent(Event event) {
		String type = event.getTopic();

		PO po = getPO(event);
		log.info(po + " Type: " + type);

		if (type.equals(IEventTopics.AFTER_LOGIN)) {
			String accountType = MSysConfig.getValue(RajaOngkir.RAJAONGKIR_ACCOUNT_TYPE, "starter");
			Env.setContext(Env.getCtx(), "#RAJAONGKIR_ACCOUNT_TYPE", accountType);
		}
		
	}


}
