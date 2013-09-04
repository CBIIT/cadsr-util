/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.dto.bc4j;

import gov.nih.nci.ncicb.cadsr.common.resource.Context;

import java.sql.Date;
import java.sql.SQLException;
import java.io.Serializable;
import gov.nih.nci.ncicb.cadsr.common.dto.base.AuditTransferObject;
import gov.nih.nci.ncicb.cadsr.common.persistence.bc4j.ContextsViewRowImpl;

public class BC4JContextTransferObject extends AuditTransferObject 
                     implements Context,Serializable {
	protected String conteIdseq;
	protected String name;
	protected String llName;
	protected String palName;
	protected String description;
	protected String lang;
	protected Float version;

	public BC4JContextTransferObject() {
	}

	public BC4JContextTransferObject(ContextsViewRowImpl conteViewRowImpl) {
		conteIdseq = conteViewRowImpl.getConteIdseq().trim();
		name = conteViewRowImpl.getName();
		llName = conteViewRowImpl.getLlName();
		palName = conteViewRowImpl.getPalName();
		description = conteViewRowImpl.getDescription();
		version = new Float(conteViewRowImpl.getVersion().floatValue());
		lang = conteViewRowImpl.getLanguage();
		createdBy = conteViewRowImpl.getCreatedBy();
		//createdDate = (Date)conteViewRowImpl.getDateCreated().getData();
		modifiedBy = conteViewRowImpl.getModifiedBy();
		//modifiedDate = (Date)(conteViewRowImpl.getDateModified().getData());
		version = new Float(conteViewRowImpl.getVersion().floatValue());

	} //end method

	public String getConteIdseq() {
		return conteIdseq;
	} //end method

	public String getName() {
		return name;
	} //end method

	public String getLlName() {
		return llName;
	} //end method

	public String getPalName() {
		return palName;
	} //end method

	public String getDescription() {
		return description;
	} //end method

	public Float getVersion() {
		return version;
	}

	public String getLanguage() {
		return lang;
	}

	public void setConteIdseq(String pConteIdseq) {
		conteIdseq = pConteIdseq;
	}

	public void setName(String pName) {
		name = pName;
	}

	public void setLlName(String pLlName) {
		llName = pLlName;
	}

	public void setPalName(String pPalName) {
		palName = pPalName;
	}

	public void setDescription(String pDescription) {
		description = pDescription;
	}

	public void setLanguage(String pLanguage) {
		lang = pLanguage;
	}
}
