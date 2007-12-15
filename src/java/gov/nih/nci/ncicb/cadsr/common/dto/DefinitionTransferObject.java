package gov.nih.nci.ncicb.cadsr.common.dto;

import gov.nih.nci.ncicb.cadsr.common.resource.ClassSchemeItem;
import gov.nih.nci.ncicb.cadsr.common.resource.Context;
import gov.nih.nci.ncicb.cadsr.common.resource.Definition;

import java.util.ArrayList;
import java.util.List;

public class DefinitionTransferObject implements Definition
{
    private Context context;
    private String type;
    private String  id;
    private String definition;
    private List<ClassSchemeItem> csCsis ;
    private String language;

    public DefinitionTransferObject() {
    }
    

    public void addCsCsi(ClassSchemeItem newCsCsi){
        if (csCsis == null){
            csCsis = new ArrayList();
        }
        csCsis.add(newCsCsi);
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getDefinition() {
        return definition;
    }

    public void setCsCsis(List<ClassSchemeItem> csCsis) {
        this.csCsis = csCsis;
    }

    public List<ClassSchemeItem> getCsCsis() {
        return csCsis;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
