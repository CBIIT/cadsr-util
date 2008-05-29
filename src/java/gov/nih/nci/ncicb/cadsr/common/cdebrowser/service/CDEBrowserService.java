package gov.nih.nci.ncicb.cadsr.common.cdebrowser.service;

import gov.nih.nci.ncicb.cadsr.common.resource.DataElement;
import gov.nih.nci.ncicb.cadsr.objectCart.CDECart;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

public interface CDEBrowserService 
{
	public Properties getApplicationProperties(Locale locale);
	public Properties reloadApplicationProperties(Locale locale, String username);
	public void populateDataElementAltNameDef (DataElement de);
	public List getReferenceDocuments(String acIdseq);
	//public List getReferenceDocumentsForCSI(String cscsiIdseq);	
}