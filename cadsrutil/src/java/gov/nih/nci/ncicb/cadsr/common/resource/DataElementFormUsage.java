/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.resource;

public interface DataElementFormUsage  {
  public String getProtocolLongName();
  public String getFormLongName();
  public String getUsageType();
  public String getProtocolLeadOrg();
  public String getQuestionLongName();
}