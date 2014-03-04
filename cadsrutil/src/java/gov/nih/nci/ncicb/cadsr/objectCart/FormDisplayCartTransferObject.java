package gov.nih.nci.ncicb.cadsr.objectCart;

import java.io.Serializable;
import java.util.List;

public class FormDisplayCartTransferObject implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected int publicId;
	protected String longName;
	protected String contextName = null;
	protected String formType = null;
	protected String aslName;
	protected Float version;
	protected List protocols = null;	
	protected String idseq;
	

	public int getPublicId() {
		return publicId;
	}

	public void setPublicId(int publicId) {
		this.publicId = publicId;
	}

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public String getContextName() {
		return contextName;
	}

	public void setContextName(String contextName) {
		this.contextName = contextName;
	}

	public String getFormType() {
		return formType;
	}

	public void setFormType(String formType) {
		this.formType = formType;
	}

	public String getAslName() {
		return aslName;
	}

	public void setAslName(String aslName) {
		this.aslName = aslName;
	}

	public Float getVersion() {
		return version;
	}

	public void setVersion(Float version) {
		this.version = version;
	}

	public List getProtocols() {
		return protocols;
	}

	public void setProtocols(List protocols) {
		this.protocols = protocols;
	}

	public String getIdseq() {
		return idseq;
	}

	public void setIdseq(String idseq) {
		this.idseq = idseq;
	}

}
