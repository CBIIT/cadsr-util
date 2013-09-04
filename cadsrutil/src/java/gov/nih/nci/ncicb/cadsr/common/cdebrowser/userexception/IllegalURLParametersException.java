/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.cdebrowser.userexception;

import gov.nih.nci.ncicb.cadsr.common.exception.NestedCheckedException;

public class IllegalURLParametersException extends  NestedCheckedException {
  public IllegalURLParametersException(String msg) {
    super(msg);
  }

  public IllegalURLParametersException(String msg, Exception ex) {
    super(msg,ex);
  }
}