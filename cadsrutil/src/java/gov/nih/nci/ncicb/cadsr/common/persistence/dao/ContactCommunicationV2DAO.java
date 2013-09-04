/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.persistence.dao;

import gov.nih.nci.ncicb.cadsr.common.exception.DMLException;
import gov.nih.nci.ncicb.cadsr.common.resource.ContactCommunicationV2;

import java.util.List;

public interface ContactCommunicationV2DAO extends AdminComponentDAO {

  public List<ContactCommunicationV2> getContactCommunicationV2sForAC(String acId) throws DMLException;

  }
