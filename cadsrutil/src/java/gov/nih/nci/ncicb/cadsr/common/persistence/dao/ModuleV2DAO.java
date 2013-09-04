/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.persistence.dao;

import gov.nih.nci.ncicb.cadsr.common.exception.DMLException;

import java.util.Collection;


public interface ModuleV2DAO extends AdminComponentDAO {

  public Collection getQuestionsInAModuleV2(String moduleId) throws DMLException;

  }
