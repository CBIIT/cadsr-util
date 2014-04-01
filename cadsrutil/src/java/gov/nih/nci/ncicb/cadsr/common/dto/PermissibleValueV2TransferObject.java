/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.dto;

import gov.nih.nci.ncicb.cadsr.common.resource.PermissibleValueV2;
import gov.nih.nci.ncicb.cadsr.common.resource.ValueMeaningV2;

public class PermissibleValueV2TransferObject implements PermissibleValueV2 {

	protected String value;
	protected ValueMeaningV2 valueMeaningV2;
	
	protected String idseq;

	public PermissibleValueV2TransferObject() {
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ValueMeaningV2 getValueMeaningV2() {
		return valueMeaningV2;
	}

	public void setValueMeaningV2(ValueMeaningV2 valueMeaningV2) {
		this.valueMeaningV2 = valueMeaningV2;
	}

	public String getIdseq() {
		return idseq;
	}

	public void setIdseq(String idseq) {
		this.idseq = idseq;
	}
}
