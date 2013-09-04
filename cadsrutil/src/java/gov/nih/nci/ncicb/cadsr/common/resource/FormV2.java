/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.resource;

import java.util.List;

public interface FormV2 extends Form  {

   public String getChangeNote();
   public void setChangeNote(String aChangeNote);

   public List getContactCommunicationV2();
   public void setContactCommunicationV2(List contactCommunicationsV2);

}