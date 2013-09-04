/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.resource;

public interface ContactCommunicationV2 extends ContactCommunication, Audit {

	public void setOrganizationName(String name);

	public String getOrganizationName();

	public void setOrganizationRAI(String rai);

	public String getOrganizationRAI();

	public void setPerson(Person person);

	public Person getPerson();

}
