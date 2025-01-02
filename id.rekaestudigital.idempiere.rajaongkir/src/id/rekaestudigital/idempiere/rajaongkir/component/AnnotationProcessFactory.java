package id.rekaestudigital.idempiere.rajaongkir.component;

import org.adempiere.base.AnnotationBasedProcessFactory;

public class AnnotationProcessFactory extends AnnotationBasedProcessFactory {

	@Override
	protected String[] getPackages() {
		return new String[] { "id.rekaestudigital.idempiere.rajaongkir.process" };
	}

}
