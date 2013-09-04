/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.persistence.dao;

import gov.nih.nci.ncicb.cadsr.common.exception.DMLException;
import gov.nih.nci.ncicb.cadsr.common.resource.Question;

import gov.nih.nci.ncicb.cadsr.common.resource.ReferenceDocument;
import java.util.Collection;


public interface ReferenceDocumentDAO extends AdminComponentDAO{

  /**
   * Creates a new reference document (just the header info).
   *
   * @param <b>newRefDoc</b> ReferenceDocument object
   *
   * @return <b>newQuestion</b> returns ReferenceDocument object
   *
   * @throws <b>DMLException</b>
   */
  public ReferenceDocument createReferenceDoc(ReferenceDocument newRefDoc, String acIdSeq)
    throws DMLException;

  public int deleteReferenceDocument(String refDocId) throws DMLException ;
  public int updateReferenceDocument(ReferenceDocument refDoc) throws DMLException;
  public int deleteAttachment(String name) throws DMLException ;


}
