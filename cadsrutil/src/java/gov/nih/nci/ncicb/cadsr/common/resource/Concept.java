/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.resource;

public interface Concept extends AdminComponent {

  public void setCode(String id);

  public String getCode();

  /**
   * Get the DefinitionSource value.
   *
   * @return the DefinitionSource value.
   */
  public String getDefinitionSource();

  /**
   * Set the DefinitionSource value.
   *
   * @param newDefinitionSource The new DefinitionSource value.
   */
  public void setDefinitionSource(String newDefinitionSource);

  public void setEvsSource(String evsSource);

  public String getEvsSource();
}
