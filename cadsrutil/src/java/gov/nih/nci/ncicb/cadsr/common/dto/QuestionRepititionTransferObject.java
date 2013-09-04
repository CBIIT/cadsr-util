/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.dto;

import gov.nih.nci.ncicb.cadsr.common.resource.FormValidValue;
import gov.nih.nci.ncicb.cadsr.common.resource.Question;
import gov.nih.nci.ncicb.cadsr.common.resource.QuestionRepitition;

public class QuestionRepititionTransferObject implements QuestionRepitition
{
    private Question question;
    private String defaultValue;
    private FormValidValue defaultValidValue;
    private int repeatSequence;
    private boolean editable;
    
    public QuestionRepititionTransferObject()
    {
    }

    public void setQuestion(Question question)
    {
        this.question = question;
    }

    public Question getQuestion()
    {
        return question;
    }

    public void setDefaultValue(String defaultValue)
    {
        this.defaultValue = defaultValue;
    }

    public String getDefaultValue()
    {
        return defaultValue;
    }

    public void setDefaultValidValue(FormValidValue defaultValidValue)
    {
        this.defaultValidValue = defaultValidValue;
    }

    public FormValidValue getDefaultValidValue()
    {
        return defaultValidValue;
    }

    public void setRepeatSequence(int repeatSequence)
    {
        this.repeatSequence = repeatSequence;
    }

    public int getRepeatSequence()
    {
        return repeatSequence;
    }
    
	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}
}
