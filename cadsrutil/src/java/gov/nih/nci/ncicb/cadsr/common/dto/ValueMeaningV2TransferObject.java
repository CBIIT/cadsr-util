/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.dto;

import gov.nih.nci.ncicb.cadsr.common.resource.ValueMeaningV2;


public class ValueMeaningV2TransferObject extends ValueMeaningTransferObject implements ValueMeaningV2 {
	
	protected String preferredDefinition;
	
	public ValueMeaningV2TransferObject() {
	}
	
	public void setPreferredDefinition(String preferredDefinition) {
		this.preferredDefinition = preferredDefinition;
	}

	public String getPreferredDefinition() {
		return preferredDefinition;
	}
}
