/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.util;

public class ConnectException extends Exception 
{
  private String userMessage = null;
  
  public ConnectException(String msg)
  {
    userMessage = msg;
  }

  public String getUserMessage()
  {
    return userMessage;
  }
}