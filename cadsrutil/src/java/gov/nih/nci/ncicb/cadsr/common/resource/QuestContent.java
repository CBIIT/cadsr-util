/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.resource;

public interface QuestContent extends AdminComponent  {
  public String getQcIdseq();
  public void setQcIdseq(String qcIdseq);

  public String getQuestContentType();
  public void setQuestContentType(String qtlName);
}