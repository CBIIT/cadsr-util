/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface InstructionChanges extends Serializable
{

  public String getParentId();
  public void setParentId(String parentId);
  
  public Instruction getUpdatedInstruction();
  public void setUpdatedInstruction(Instruction instructions);

  public Instruction getNewInstruction();
  public void setNewInstruction(Instruction instructions);
  
  public Instruction getDeletedInstruction();
  public void setDeletedInstruction(Instruction instructions);
  
  public boolean isEmpty();
}
