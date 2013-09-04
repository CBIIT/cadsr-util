/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.resource;
import javax.swing.tree.DefaultMutableTreeNode;

public interface ContextHolder 
{

  public void setContext(Context context);


  public Context getContext();

  public void setNode(DefaultMutableTreeNode node);


  public DefaultMutableTreeNode getNode();
}