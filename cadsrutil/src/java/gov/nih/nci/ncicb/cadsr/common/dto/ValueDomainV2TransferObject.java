package gov.nih.nci.ncicb.cadsr.common.dto;

import gov.nih.nci.ncicb.cadsr.common.resource.ValueDomainV2;

import java.util.List;

public class ValueDomainV2TransferObject extends ValueDomainTransferObject
		implements ValueDomainV2 {

	protected List permissibleValueV2;

	public ValueDomainV2TransferObject() {
	}

	public List getPermissibleValueV2() {
		return permissibleValueV2;
	}

	public void setPermissibleValueV2(List permissibleValueV2) {
		this.permissibleValueV2 = permissibleValueV2;
	}
}
