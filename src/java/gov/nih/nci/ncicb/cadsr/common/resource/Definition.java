package gov.nih.nci.ncicb.cadsr.common.resource;
import java.util.List;
import java.io.Serializable;

public interface Definition extends Serializable {
    public Context getContext();
    public String getId() ;
    public String getDefinition();
    public List getCsCsis() ;
    public String getLanguage();

    public void addCsCsi(ClassSchemeItem newCsCsi) ;
    public String getType();

    public void setType(String newType);

    public void setDefinition(String newDefinition);

    public void setContext(Context newContext);

    public void setId(String newId) ;
    
    public void setLanguage(String language);
 

}