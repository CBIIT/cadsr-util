package gov.nih.nci.ncicb.cadsr.common.resource;

import java.util.List;


public interface ValueMeaningV2 extends ValueMeaning {

	public void setPreferredDefinition(String preferredDefinition);

	public String getPreferredDefinition();
}
