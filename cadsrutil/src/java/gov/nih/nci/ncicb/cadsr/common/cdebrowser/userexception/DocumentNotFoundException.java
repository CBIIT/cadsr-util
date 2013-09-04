/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.cdebrowser.userexception;
import java.io.*;

public class DocumentNotFoundException extends Exception implements Serializable {
  String msg = "";
  public DocumentNotFoundException() {
  }
  public DocumentNotFoundException(String message) {
    msg = message;
  }
  public String getMessage(){
    return msg;
  }
}