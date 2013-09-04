/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.dto;

import gov.nih.nci.ncicb.cadsr.common.resource.ConceptDerivationRule;
import gov.nih.nci.ncicb.cadsr.common.resource.Representation;

public class RepresentationTransferObject extends AdminComponentTransferObject implements Representation
{
    private String name=null;
    private ConceptDerivationRule conceptDerivationRule;
    
    public RepresentationTransferObject()
    {
    }
    public String getName()
    {
      return name;
    }
    public void setName(String newName)
    {
      name=newName;
    }
    
    
    public ConceptDerivationRule getConceptDerivationRule()
    {
      return conceptDerivationRule;
    }
    public void setConceptDerivationRule(ConceptDerivationRule newConceptDerivationRule)
    {
      conceptDerivationRule=newConceptDerivationRule;
    }
}