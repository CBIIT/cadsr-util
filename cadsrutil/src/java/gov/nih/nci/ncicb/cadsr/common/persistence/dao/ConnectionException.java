/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.persistence.dao;

import gov.nih.nci.ncicb.cadsr.common.exception.NestedRuntimeException;

public class ConnectionException extends NestedRuntimeException {
  public ConnectionException(String msg) {
    super(msg);
  }

  public ConnectionException(String msg, Exception ex) {
    super(msg,ex);
  }
}