package gov.nih.nci.ncicb.cadsr.common.dto;

import gov.nih.nci.ncicb.cadsr.common.resource.ContactCommunicationV2;
import gov.nih.nci.ncicb.cadsr.common.resource.Person;

public class ContactCommunicationV2TransferObject extends
ContactCommunicationTransferObject implements ContactCommunicationV2 {
	protected String organizationName;
	protected String organizationRAI;
	protected Person person;

	public ContactCommunicationV2TransferObject() {
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationRAI(String organizationRAI) {
		this.organizationRAI = organizationRAI;
	}

	public String getOrganizationRAI() {
		return organizationRAI;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	public String toString() {
		// not supported
		return "ContactCommunicationV2TransferObject::toString not supported";
	}
	
}
