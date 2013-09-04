/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.persistence.dao;

import gov.nih.nci.ncicb.cadsr.common.exception.DMLException;
import gov.nih.nci.ncicb.cadsr.common.resource.FormInstruction;

import gov.nih.nci.ncicb.cadsr.common.resource.Instruction;
import java.util.Collection;
import java.util.List;


public interface FormInstructionDAO extends InstructionDAO {

  public int createInstruction(Instruction formInstr, String parentId)
    throws DMLException;

  public int createFooterInstruction(Instruction formInstr, String parentId)
     throws DMLException;
     
  public List getInstructions(String formID);
  
  public List getFooterInstructions(String formID);

}
