/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.contexttree;
import java.util.Map;
import javax.swing.tree.DefaultMutableTreeNode;

public class CsCsiCategorytHolder 
{
  
  private DefaultMutableTreeNode node= null;
  private Map categoryHolder = null;
  public CsCsiCategorytHolder()
  {
  }

  public Map getCategoryHolder()
  {
    return categoryHolder;
  }

  public void setCategoryHolder(Map categoryHolder)
  {
    this.categoryHolder = categoryHolder;
  }

  public DefaultMutableTreeNode getNode()
  {
    return node;
  }

  public void setNode(DefaultMutableTreeNode node)
  {
    this.node = node;
  }
}