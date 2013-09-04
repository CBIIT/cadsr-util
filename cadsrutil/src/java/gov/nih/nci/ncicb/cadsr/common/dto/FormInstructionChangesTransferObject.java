/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.dto;
import gov.nih.nci.ncicb.cadsr.common.resource.FormInstructionChanges;
import java.util.Map;

public class FormInstructionChangesTransferObject implements FormInstructionChanges
{
  private Map formHeaderInstructionChanges = null;
  private Map formFooterInstructionChanges = null;
  
  public FormInstructionChangesTransferObject()
  {
  }

  
  public boolean isEmpty()
  {

    boolean fhEmpty = true;
    boolean ffEmpty = true;
    
    if(formHeaderInstructionChanges !=null && ! formHeaderInstructionChanges.isEmpty())
      fhEmpty = false;    
    if(formFooterInstructionChanges !=null && ! formFooterInstructionChanges.isEmpty())
      ffEmpty = false;          
    
    if(fhEmpty==false||ffEmpty==false)
      return false;
      
    return true;
  }

  public void setFormHeaderInstructionChanges(Map formHeaderInstructionChanges)
  {
    this.formHeaderInstructionChanges = formHeaderInstructionChanges;
  }


  public Map getFormHeaderInstructionChanges()
  {
    return formHeaderInstructionChanges;
  }


  public void setFormFooterInstructionChanges(Map formFooterInstructionChanges)
  {
    this.formFooterInstructionChanges = formFooterInstructionChanges;
  }


  public Map getFormFooterInstructionChanges()
  {
    return formFooterInstructionChanges;
  }

}