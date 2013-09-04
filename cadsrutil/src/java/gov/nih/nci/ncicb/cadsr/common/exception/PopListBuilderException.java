/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.exception;

public class PopListBuilderException extends NestedCheckedException  {

  public PopListBuilderException(String msg) {
    super(msg);
  }

  public PopListBuilderException(String msg, Exception ex) {
    super(msg,ex);
  }
}