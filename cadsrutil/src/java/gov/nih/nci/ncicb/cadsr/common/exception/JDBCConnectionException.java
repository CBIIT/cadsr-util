/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.exception;

public class JDBCConnectionException extends NestedCheckedException {
  
  public JDBCConnectionException(String msg) {
    super(msg);
  }

  public JDBCConnectionException(String msg, Exception ex) {
    super(msg,ex);
  }
}