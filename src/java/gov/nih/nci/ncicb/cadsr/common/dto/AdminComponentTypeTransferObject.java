package gov.nih.nci.ncicb.cadsr.common.dto;

import gov.nih.nci.ncicb.cadsr.common.resource.AdminComponentType;
import gov.nih.nci.ncicb.cadsr.common.resource.ComponentType;

public class AdminComponentTypeTransferObject extends AdminComponentTransferObject implements AdminComponentType {

	private ComponentType componentType;
	
	
	public void setComponentType(ComponentType componentType) {
		this.componentType = componentType;
	}

	public ComponentType getComponentType() {
		return componentType;
	}

}
