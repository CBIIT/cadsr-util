/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

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
