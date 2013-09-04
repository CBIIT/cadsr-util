/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.dto;

import gov.nih.nci.ncicb.cadsr.common.resource.Concept;


public class ConceptTransferObject extends AdminComponentTransferObject
  implements Concept {
  private String definitionSource = null;
  private String evsSource = null;
  private String code = null;

  public ConceptTransferObject() {
  }

  /**
   * Get the DefinitionSource value.
   *
   * @return the DefinitionSource value.
   */
  public String getDefinitionSource() {
      if (definitionSource == null)
         return "";
      else 
         return definitionSource;    
  }

  /**
   * Set the DefinitionSource value.
   *
   * @param newDefinitionSource The new DefinitionSource value.
   */
  public void setDefinitionSource(String newDefinitionSource) {
    definitionSource = newDefinitionSource;
  }

  public void setEvsSource(String evsSource) {
    this.evsSource = evsSource;
  }

  public String getEvsSource() {
      if (evsSource == null)
         return "";
      else 
         return evsSource;        
  }


  public void setCode(String code)
  {
    this.code = code;
  }


  public String getCode()
  {
      if (code == null)
         return "";
      else 
         return code;        
  }
}
