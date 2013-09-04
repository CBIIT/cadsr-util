/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.dto;

import gov.nih.nci.ncicb.cadsr.common.resource.Context;
import gov.nih.nci.ncicb.cadsr.common.resource.ContextHolder;

import javax.swing.tree.DefaultMutableTreeNode;

public class ContextHolderTransferObject implements ContextHolder
{
  private Context context;
  private DefaultMutableTreeNode node; 
  

  public void setContext(Context context)
  {
    this.context = context;
  }


  public Context getContext()
  {
    return context;
  }


  public void setNode(DefaultMutableTreeNode node)
  {
    this.node = node;
  }


  public DefaultMutableTreeNode getNode()
  {
    return node;
  }
}