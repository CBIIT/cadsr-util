/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.persistence.dao;

import gov.nih.nci.ncicb.cadsr.common.exception.DMLException;
import gov.nih.nci.ncicb.cadsr.common.resource.NCIUser;

import java.util.Collection;
import java.util.List;
import java.util.Map;


public interface UserManagerDAO {
  public boolean userInGroup(
    String username,
    String groupName);

  public boolean validUser(
    String userName,
    String password);

  public NCIUser getNCIUser(String userName);

  public Map getContextsForAllRoles(
    String username,
    String acType);
}
