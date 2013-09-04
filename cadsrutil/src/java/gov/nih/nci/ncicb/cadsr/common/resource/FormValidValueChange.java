/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.resource;
import java.io.Serializable;

public interface FormValidValueChange extends Serializable
{

  public String getValidValueId();
  public void setValidValueId(String vvId);
  
  public FormValidValue getUpdatedValidValue();
  public void setUpdatedValidValue(FormValidValue fvv);
  
  public InstructionChanges getInstrctionChanges();
  public void setInstrctionChanges(InstructionChanges changes);
  
  //added when valuemeaing becomes an admin components
  public String getUpdatedFormValueMeaningText();
  public void setUpdatedFormValueMeaningText(String vmText);
  public String getUpdatedFormValueMeaningDesc();
  public void setUpdatedFormValueMeaningDesc(String desc);
  
  public boolean isEmpty();
}