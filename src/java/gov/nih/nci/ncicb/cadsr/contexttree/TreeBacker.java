package gov.nih.nci.ncicb.cadsr.contexttree;


import java.io.Serializable;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.myfaces.custom.tree2.HtmlTree;
import org.apache.myfaces.custom.tree2.TreeModel;
import org.apache.myfaces.custom.tree2.TreeModelBase;
import org.apache.myfaces.custom.tree2.TreeState;
import gov.nih.nci.ncicb.webtree.LazyActionTreeModel;

/**
 * @author Jane Jiang
 * @version: $Id: TreeBacker.java,v 1.1 2007-12-15 21:54:10 hegdes Exp $
 */

public class TreeBacker implements Serializable {
   private static final long serialVersionUID = 1L;

   protected Log log = LogFactory.getLog(TreeBacker.class.getName());

   private LazyActionTreeModel _treeModel;

   private HtmlTree _tree;

   private String selectedNode;
   private TreeState treeState;

   private CDEBrowserTreeData treeData = new CDEBrowserTreeData();

   public TreeBacker() {
      // Initialize the tree with the root node
      //       String[] path = _tree.getPathInformation("0");
      //       _tree.expandPath(path);

   }

   public LazyActionTreeModel getTreeModel() {
      if (_treeModel == null) {
         _treeModel = new LazyActionTreeModel(treeData.getTreeData());
//         _treeModel.getTreeState().toggleExpanded("0");
         _treeModel.getTreeState().setTransient(true);
      }

      return _treeModel;
   }

   public String refreshTree()   {
       treeData.refreshTree();
       _treeModel = new LazyActionTreeModel(treeData.getTreeData());
//       _treeModel.getTreeState().toggleExpanded("0");
       _treeModel.getTreeState().setTransient(true);
       return null;
   }

   /**
   public void selectedNode() {
           this.selectedNode = this.getTreeModel().getNode().getDescription();
   }
*/
   public String getSelectedNode() {
      return selectedNode;
   }


   public void setTree(HtmlTree tree) {
      this._tree = tree;
   }

   public HtmlTree getTree() {
      return _tree;
   }

   public void setTreeData(CDEBrowserTreeData treeData) {
      this.treeData = treeData;
   }

   public CDEBrowserTreeData getTreeData() {
      return treeData;
   }
   
   public void selectedNode() {
      this.selectedNode = this.getTree().getNode().getDescription();
   }

}
