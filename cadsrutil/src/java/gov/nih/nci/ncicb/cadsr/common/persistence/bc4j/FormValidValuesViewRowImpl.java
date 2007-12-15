package gov.nih.nci.ncicb.cadsr.persistence.bc4j;

import gov.nih.nci.ncicb.cadsr.dto.bc4j.BC4JContextTransferObject;
import gov.nih.nci.ncicb.cadsr.resource.Context;

import oracle.jbo.domain.Number;

import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;


//  ---------------------------------------------------------------
//  ---    File generated by Oracle Business Components for Java.
//  ---------------------------------------------------------------
public class FormValidValuesViewRowImpl extends ViewRowImpl {
  public static final int QCIDSEQ = 0;
  public static final int VERSION = 1;
  public static final int QTLNAME = 2;
  public static final int CONTEIDSEQ = 3;
  public static final int ASLNAME = 4;
  public static final int PREFERREDNAME = 5;
  public static final int PREFERREDDEFINITION = 6;
  public static final int VPIDSEQ = 7;
  public static final int LONGNAME = 8;
  public static final int LATESTVERSIONIND = 9;
  public static final int DELETEDIND = 10;
  public static final int PQSTIDSEQ = 11;
  public static final int QRIDSEQ = 12;
  public static final int PQCIDSEQ = 13;
  public static final int CQCIDSEQ = 14;
  public static final int DISPLAYORDER = 15;
  public static final int QUESTION = 16;
  public static final int CONTEXT = 17;

  /**
   * This is the default constructor (do not remove)
   */
  public FormValidValuesViewRowImpl() {
  }

  /**
   * Gets qc entity object.
   */
  public QuestContentsExtImpl getqc() {
    return (QuestContentsExtImpl) getEntity(0);
  }

  /**
   * Gets qr entity object.
   */
  public QcRecsExtImpl getqr() {
    return (QcRecsExtImpl) getEntity(1);
  }

  /**
   * Gets the attribute value for QC_IDSEQ using the alias name QcIdseq
   */
  public String getQcIdseq() {
    return (String) getAttributeInternal(QCIDSEQ);
  }

  /**
   * Gets the attribute value for VERSION using the alias name Version
   */
  public Number getVersion() {
    return (Number) getAttributeInternal(VERSION);
  }

  /**
   * Sets <code>value</code> as attribute value for VERSION using the alias
   * name Version
   */
  public void setVersion(Number value) {
    setAttributeInternal(VERSION, value);
  }

  /**
   * Gets the attribute value for QTL_NAME using the alias name QtlName
   */
  public String getQtlName() {
    return (String) getAttributeInternal(QTLNAME);
  }

  /**
   * Sets <code>value</code> as attribute value for QTL_NAME using the alias
   * name QtlName
   */
  public void setQtlName(String value) {
    setAttributeInternal(QTLNAME, value);
  }

  /**
   * Gets the attribute value for CONTE_IDSEQ using the alias name ConteIdseq
   */
  public String getConteIdseq() {
    return (String) getAttributeInternal(CONTEIDSEQ);
  }

  /**
   * Sets <code>value</code> as attribute value for CONTE_IDSEQ using the alias
   * name ConteIdseq
   */
  public void setConteIdseq(String value) {
    setAttributeInternal(CONTEIDSEQ, value);
  }

  /**
   * Gets the attribute value for ASL_NAME using the alias name AslName
   */
  public String getAslName() {
    return (String) getAttributeInternal(ASLNAME);
  }

  /**
   * Sets <code>value</code> as attribute value for ASL_NAME using the alias
   * name AslName
   */
  public void setAslName(String value) {
    setAttributeInternal(ASLNAME, value);
  }

  /**
   * Gets the attribute value for PREFERRED_NAME using the alias name
   * PreferredName
   */
  public String getPreferredName() {
    return (String) getAttributeInternal(PREFERREDNAME);
  }

  /**
   * Sets <code>value</code> as attribute value for PREFERRED_NAME using the
   * alias name PreferredName
   */
  public void setPreferredName(String value) {
    setAttributeInternal(PREFERREDNAME, value);
  }

  /**
   * Gets the attribute value for PREFERRED_DEFINITION using the alias name
   * PreferredDefinition
   */
  public String getPreferredDefinition() {
    return (String) getAttributeInternal(PREFERREDDEFINITION);
  }

  /**
   * Sets <code>value</code> as attribute value for PREFERRED_DEFINITION using
   * the alias name PreferredDefinition
   */
  public void setPreferredDefinition(String value) {
    setAttributeInternal(PREFERREDDEFINITION, value);
  }

  /**
   * Gets the attribute value for VP_IDSEQ using the alias name VpIdseq
   */
  public String getVpIdseq() {
    return (String) getAttributeInternal(VPIDSEQ);
  }

  /**
   * Sets <code>value</code> as attribute value for VP_IDSEQ using the alias
   * name VpIdseq
   */
  public void setVpIdseq(String value) {
    setAttributeInternal(VPIDSEQ, value);
  }

  /**
   * Gets the attribute value for LONG_NAME using the alias name LongName
   */
  public String getLongName() {
    return (String) getAttributeInternal(LONGNAME);
  }

  /**
   * Sets <code>value</code> as attribute value for LONG_NAME using the alias
   * name LongName
   */
  public void setLongName(String value) {
    setAttributeInternal(LONGNAME, value);
  }

  /**
   * Gets the attribute value for LATEST_VERSION_IND using the alias name
   * LatestVersionInd
   */
  public String getLatestVersionInd() {
    return (String) getAttributeInternal(LATESTVERSIONIND);
  }

  /**
   * Sets <code>value</code> as attribute value for LATEST_VERSION_IND using
   * the alias name LatestVersionInd
   */
  public void setLatestVersionInd(String value) {
    setAttributeInternal(LATESTVERSIONIND, value);
  }

  /**
   * Gets the attribute value for DELETED_IND using the alias name DeletedInd
   */
  public String getDeletedInd() {
    return (String) getAttributeInternal(DELETEDIND);
  }

  /**
   * Sets <code>value</code> as attribute value for DELETED_IND using the alias
   * name DeletedInd
   */
  public void setDeletedInd(String value) {
    setAttributeInternal(DELETEDIND, value);
  }

  /**
   * Gets the attribute value for P_QST_IDSEQ using the alias name PQstIdseq
   */
  public String getPQstIdseq() {
    return (String) getAttributeInternal(PQSTIDSEQ);
  }

  /**
   * Sets <code>value</code> as attribute value for P_QST_IDSEQ using the alias
   * name PQstIdseq
   */
  public void setPQstIdseq(String value) {
    setAttributeInternal(PQSTIDSEQ, value);
  }

  /**
   * Gets the attribute value for QR_IDSEQ using the alias name QrIdseq
   */
  public String getQrIdseq() {
    return (String) getAttributeInternal(QRIDSEQ);
  }

  public void setQrIdseq(String value) {
  }

  /**
   * Gets the attribute value for P_QC_IDSEQ using the alias name PQcIdseq
   */
  public String getPQcIdseq() {
    return (String) getAttributeInternal(PQCIDSEQ);
  }

  public void setPQcIdseq(String value) {
  }

  /**
   * Gets the attribute value for C_QC_IDSEQ using the alias name CQcIdseq
   */
  public String getCQcIdseq() {
    return (String) getAttributeInternal(CQCIDSEQ);
  }

  public void setCQcIdseq(String value) {
  }

  /**
   * Gets the attribute value for DISPLAY_ORDER using the alias name
   * DisplayOrder
   */
  public Number getDisplayOrder() {
    return (Number) getAttributeInternal(DISPLAYORDER);
  }

  public void setDisplayOrder(Number value) {
  }

  //  Generated method. Do not modify.
  protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef)
    throws Exception {
    switch (index)
      {
      case QCIDSEQ:
        return getQcIdseq();
      case VERSION:
        return getVersion();
      case QTLNAME:
        return getQtlName();
      case CONTEIDSEQ:
        return getConteIdseq();
      case ASLNAME:
        return getAslName();
      case PREFERREDNAME:
        return getPreferredName();
      case PREFERREDDEFINITION:
        return getPreferredDefinition();
      case VPIDSEQ:
        return getVpIdseq();
      case LONGNAME:
        return getLongName();
      case LATESTVERSIONIND:
        return getLatestVersionInd();
      case DELETEDIND:
        return getDeletedInd();
      case PQSTIDSEQ:
        return getPQstIdseq();
      case QRIDSEQ:
        return getQrIdseq();
      case PQCIDSEQ:
        return getPQcIdseq();
      case CQCIDSEQ:
        return getCQcIdseq();
      case DISPLAYORDER:
        return getDisplayOrder();
      case QUESTION:
        return getQuestion();
      case CONTEXT:
        return getContext();
      default:
        return super.getAttrInvokeAccessor(index, attrDef);
      }
  }

  //  Generated method. Do not modify.
  protected void setAttrInvokeAccessor(
    int index, Object value, AttributeDefImpl attrDef)
    throws Exception {
    switch (index)
      {
      case VERSION:
        setVersion((Number)value);
        return;
      case QTLNAME:
        setQtlName((String)value);
        return;
      case CONTEIDSEQ:
        setConteIdseq((String)value);
        return;
      case ASLNAME:
        setAslName((String)value);
        return;
      case PREFERREDNAME:
        setPreferredName((String)value);
        return;
      case PREFERREDDEFINITION:
        setPreferredDefinition((String)value);
        return;
      case VPIDSEQ:
        setVpIdseq((String)value);
        return;
      case LONGNAME:
        setLongName((String)value);
        return;
      case LATESTVERSIONIND:
        setLatestVersionInd((String)value);
        return;
      case DELETEDIND:
        setDeletedInd((String)value);
        return;
      case PQSTIDSEQ:
        setPQstIdseq((String)value);
        return;
      case QRIDSEQ:
        setQrIdseq((String)value);
        return;
      case PQCIDSEQ:
        setPQcIdseq((String)value);
        return;
      case CQCIDSEQ:
        setCQcIdseq((String)value);
        return;
      case DISPLAYORDER:
        setDisplayOrder((Number)value);
        return;
      default:
        super.setAttrInvokeAccessor(index, value, attrDef);
        return;
      }
  }

  /**
   * Gets the associated <code>Row</code> using master-detail link Question
   */
  public oracle.jbo.Row getQuestion() {
    return (oracle.jbo.Row) getAttributeInternal(QUESTION);
  }

  /**
   * Gets the associated <code>Row</code> using master-detail link Context
   */
  public oracle.jbo.Row getContext() {
    return (oracle.jbo.Row) getAttributeInternal(CONTEXT);
  }

  public Context getContextTransferObject() {
    Context conte =
      new BC4JContextTransferObject((ContextsViewRowImpl) getContext());

    return conte;
  }
}
