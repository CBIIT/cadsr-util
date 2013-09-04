/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.resource;
import java.io.Serializable;
import java.util.Map;

public interface FormInstructionChanges extends Serializable
{

  public static final String DELETED_INSTRUCTIONS="deletedInstructions";
  public static final String NEW_INSTRUCTION_MAP="newInstructionMap";
  public static final String UPDATED_INSTRUCTIONS="updatedInstructions";  
  
  public void setFormHeaderInstructionChanges(Map formHeaderInstructionChanges);


  public Map getFormHeaderInstructionChanges();


  public void setFormFooterInstructionChanges(Map formFooterInstructionChanges);


  public Map getFormFooterInstructionChanges();
  
  public boolean isEmpty();
}