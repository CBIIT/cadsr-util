/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.resource;

import java.io.Serializable;

public interface QuestionRepitition extends Serializable
{

    public void setDefaultValue(String defaultValue);

    public String getDefaultValue();

    public void setDefaultValidValue(FormValidValue defaultValidValue);

    public FormValidValue getDefaultValidValue();

    public void setRepeatSequence(int repeatSequence);

    public int getRepeatSequence();
    
    public boolean isEditable();
    
    public void setEditable(boolean editable);
}
