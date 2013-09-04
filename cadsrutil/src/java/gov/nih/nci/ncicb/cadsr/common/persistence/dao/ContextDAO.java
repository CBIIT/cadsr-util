/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.persistence.dao;
import gov.nih.nci.ncicb.cadsr.common.resource.Context;
import java.util.Collection;
import java.util.List;
public interface ContextDAO  {
  public static final String CTEP="CTEP";
  public Collection getAllContexts();
  public Context getContextByName(String name);  
  public Collection getContexts(String username, String businessRole);
  /**
   * Gets all the contexts excluding the contexts 
   */
  public List getAllContexts(String excludeList);
}