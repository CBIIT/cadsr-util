/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.dto;

import gov.nih.nci.ncicb.cadsr.common.resource.FormV2;

import java.util.List;



public class FormV2TransferObject extends FormTransferObject 
  implements FormV2 {


  protected String changeNote;
  protected List contactCommunicationV2;


  public FormV2TransferObject() {
  }


  public String getChangeNote() {
    return changeNote;
  }

  public void setChangeNote(String aChangeNote) {
    changeNote = aChangeNote;
  }

  public List getContactCommunicationV2() {
    return contactCommunicationV2;
  }

  public void setContactCommunicationV2(List contactCommunicationV2) {
    this.contactCommunicationV2 = contactCommunicationV2;
  }


  public String toString()
  {
    return "FormV2TransferObject::toString not supported";
  }


  
}