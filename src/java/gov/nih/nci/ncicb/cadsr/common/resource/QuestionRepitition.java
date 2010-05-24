package gov.nih.nci.ncicb.cadsr.common.resource;

public interface QuestionRepitition
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
