package gov.nih.nci.ncicb.cadsr.common.resource;

import java.util.Collection;

public interface PermissibleValueV2 {

	public void setValue(String value);

	public String getValue();

	public ValueMeaningV2 getValueMeaningV2();

	public void setValueMeaningV2(ValueMeaningV2 valueMeaningV2);	
}
