/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.resource;

public interface ObjectClass extends AdminComponent
{
  public String getName();
  public void setName(String newName);
  
  public String getQualifier();
  public void setQualifier(String newQualifier);

  public ConceptDerivationRule getConceptDerivationRule();
  public void setConceptDerivationRule(ConceptDerivationRule newConceptDerivationRule);  
  
}