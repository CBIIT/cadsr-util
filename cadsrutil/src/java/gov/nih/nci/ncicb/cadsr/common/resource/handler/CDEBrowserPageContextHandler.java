/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.resource.handler;
import java.util.*;
import oracle.cle.persistence.*;
import oracle.cle.resource.*;

public interface CDEBrowserPageContextHandler extends HandlerDefinition  {
  public Object findPageContext(String nodeType
                               ,String nodeIdseq
                               ,Object sessionId) throws Exception;
}