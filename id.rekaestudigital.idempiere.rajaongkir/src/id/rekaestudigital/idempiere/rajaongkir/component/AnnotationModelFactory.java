package id.rekaestudigital.idempiere.rajaongkir.component;

import org.adempiere.base.AnnotationBasedModelFactory;
import id.rekaestudigital.idempiere.rajaongkir.model.MSubdistrict;

public class AnnotationModelFactory extends AnnotationBasedModelFactory {
	
	@Override
	protected String[] getPackages() {
		return new String[] { MSubdistrict.class.getPackageName() };
	}
}
