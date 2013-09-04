/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.dto;
import gov.nih.nci.ncicb.cadsr.common.resource.FormValidValue;
import gov.nih.nci.ncicb.cadsr.common.resource.InstructionChanges;
import gov.nih.nci.ncicb.cadsr.common.resource.FormValidValueChange;
import java.util.List;

public class FormValidValueChangeTransferObject implements FormValidValueChange 
{

  private FormValidValue updatedValidValue = null;
  private InstructionChanges instructionChanges = null;
  private String vvId = null;
  private String updatedFormValueMeaningText = null;
  private String updatedFormValueMeaningDesc = null;
  
  public FormValidValueChangeTransferObject()
  {
  }

  public String getValidValueId()
  {
    return vvId;
  }
  public void setValidValueId(String vvId)
  {
    this.vvId = vvId;
  }
  
  public FormValidValue getUpdatedValidValue()
  {
    return updatedValidValue;
  }

  public void setUpdatedValidValue(FormValidValue fvv)
  {
    this.updatedValidValue=fvv;
  }

  public InstructionChanges getInstrctionChanges()
  {
    return instructionChanges;
  }

  public void setInstrctionChanges(InstructionChanges changes)
  {
    instructionChanges = changes;
  }

  public boolean isEmpty()
  {
    //if(updatedValueValue==null&&instructionChanges==null)
    //  return true;
      
    boolean result = true;
    if(instructionChanges!=null&&(!instructionChanges.isEmpty()))
      result =false;
    if(updatedValidValue!=null)
      result =false;
    if (updatedFormValueMeaningText !=null)
        return false;
    if (updatedFormValueMeaningDesc !=null) 
        return false;
    return result;
  }

    public void setUpdatedFormValueMeaningText(String formValueMeaningText) {
        this.updatedFormValueMeaningText = formValueMeaningText;
    }

    public String getUpdatedFormValueMeaningText() {
        return updatedFormValueMeaningText;
    }

    public void setUpdatedFormValueMeaningDesc(String formValueMeaningDesc) {
        this.updatedFormValueMeaningDesc = formValueMeaningDesc;
    }

    public String getUpdatedFormValueMeaningDesc() {
        return updatedFormValueMeaningDesc;
    }
}
