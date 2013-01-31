package gov.nih.nci.ncicb.cadsr.common.resource;

public interface ContactCommunicationV2 extends ContactCommunication, Audit {

	public void setOrganizationName(String name);

	public String getOrganizationName();

	public void setOrganizationRAI(String rai);

	public String getOrganizationRAI();

	public void setPerson(Person person);

	public Person getPerson();

}
