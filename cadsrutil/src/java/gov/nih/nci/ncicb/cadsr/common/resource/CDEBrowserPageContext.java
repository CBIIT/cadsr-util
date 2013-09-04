/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.resource;

public interface CDEBrowserPageContext  {
  public String getContextName();
  public String getCDETemplateName();
  public String getClassSchemeName();
  public String getClassSchemeItemName();
  public String getPageContextDisplayText();
  public String getConteIdseq();
  
}