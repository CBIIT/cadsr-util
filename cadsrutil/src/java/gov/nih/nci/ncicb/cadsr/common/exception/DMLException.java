/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.exception;

import gov.nih.nci.ncicb.cadsr.common.exception.NestedRuntimeException;

public class DMLException extends NestedRuntimeException {

  public DMLException(String msg) {
    super(msg);
  }

  public DMLException(
    String msg,
    Throwable cause) {
    super(msg, cause);
  }



 /** public DataAccessException(Throwable cause) {
    super(cause);
  }
  **/
}