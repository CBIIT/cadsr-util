/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.resource;

public interface Instruction  extends AdminComponent {
  
  public int getDisplayOrder();
  public void setDisplayOrder(int order);

  public String getIdseq();
  public void setIdseq(String idseq);
  
  public Object clone() throws CloneNotSupportedException ;
  
}