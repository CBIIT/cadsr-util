package gov.nih.nci.ncicb.cadsr.common.dto;

import gov.nih.nci.ncicb.cadsr.common.resource.FormV2;

import java.util.List;



public class FormV2TransferObject extends FormTransferObject 
  implements FormV2 {



  protected String changeNote;

  public FormV2TransferObject() {
  }


  public String getChangeNote() {
    return changeNote;
  }

  public void setChangeNote(String aChangeNote) {
    changeNote = aChangeNote;
  }




  public String toString()
  {
    return "FormV2TransferObject::toString not supported";
  }


  
  }