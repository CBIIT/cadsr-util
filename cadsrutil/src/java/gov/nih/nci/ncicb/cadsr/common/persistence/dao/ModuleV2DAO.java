package gov.nih.nci.ncicb.cadsr.common.persistence.dao;

import gov.nih.nci.ncicb.cadsr.common.exception.DMLException;

import java.util.Collection;


public interface ModuleV2DAO extends AdminComponentDAO {

  public Collection getQuestionsInAModuleV2(String moduleId) throws DMLException;

  }
