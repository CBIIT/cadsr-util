package gov.nih.nci.ncicb.cadsr.common.persistence.dao;

import gov.nih.nci.ncicb.cadsr.common.exception.DMLException;
import gov.nih.nci.ncicb.cadsr.common.resource.FormV2;



public interface FormV2DAO extends AdminComponentDAO {

  public FormV2 findFormV2ByPrimaryKey(String formId) throws DMLException;

  }
