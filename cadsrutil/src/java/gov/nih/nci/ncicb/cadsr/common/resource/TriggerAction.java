/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.resource;

import java.util.List;

import gov.nih.nci.ncicb.cadsr.common.resource.ClassSchemeItem;
import gov.nih.nci.ncicb.cadsr.common.resource.FormElement;
import gov.nih.nci.ncicb.cadsr.common.resource.Protocol;

public interface TriggerAction extends Cloneable
{

    public void setIdSeq(String idSeq);

    public String getIdSeq();
    
    public void setActionSource(FormElement actionSource);

    public FormElement getActionSource();

    public void setActionTarget(FormElement actionTarget);

    public FormElement getActionTarget();
    
    public void setProtocols(List<Protocol> protocols);

    public List<Protocol> getProtocols();

    public void setClassSchemeItems(List<ClassSchemeItem> classSchemeItems);

    public List<ClassSchemeItem> getClassSchemeItems();
 
    public void setInstruction(String instruction);

    public String getInstruction();   
    
    public Object clone() throws CloneNotSupportedException ;   
}
