/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.resource;

import java.io.Serializable;
import java.util.List;

public interface Designation extends Serializable {
  public String getType();
  public String getName();
  public String getDesigIDSeq();
  public Context getContext();
  public String getLanguage();
  public List <ClassSchemeItem> getCsCsis();
  public void addCscsi (ClassSchemeItem cscsi);

}