/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.resource;

import java.util.List;

public interface FormElement extends AdminComponent
{

    public void setTriggerActions(List<TriggerAction> triggerActions);

    public List<TriggerAction> getTriggerActions();

}
