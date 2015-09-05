

package z2_userregister;


import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class DynamicTree extends JPanel {
    protected DefaultMutableTreeNode rootNode;
    protected DefaultTreeModel treeModel;
    protected JTree tree;
    EventAggregator eaggregator;

    TreeSelectionListener treeSelectionListener = new TreeSelectionListener() {

        @Override
        public void valueChanged(TreeSelectionEvent tse) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                           tree.getLastSelectedPathComponent();


                if (node == null) return;
                if(node.getParent() == rootNode) {
                    Object nodeInfo = node.getUserObject();
                    String s = (String)nodeInfo;
                    eaggregator.publish(new Category(s.toLowerCase()));
                }
                else if(node != rootNode) {
                    DefaultMutableTreeNode parent = (DefaultMutableTreeNode)node.getParent();
                    int id = parent.getIndex(node);
                    Object nodeInfo = parent.getUserObject();
                    String s = (String)nodeInfo;
                    eaggregator.publish(new Category(s.toLowerCase()));
                    eaggregator.publish(new Persona(id));
                }
            }
    };
    
    public DynamicTree(EventAggregator eaggregator) {
        super(new GridLayout(1,0));
        this.eaggregator = eaggregator;
        rootNode = new DefaultMutableTreeNode("");
        treeModel = new DefaultTreeModel(rootNode);
	treeModel.addTreeModelListener(new MyTreeModelListener());
        tree = new JTree(treeModel);
        tree.setEditable(true);
        tree.getSelectionModel().setSelectionMode
                (TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setShowsRootHandles(true);
        tree.addTreeSelectionListener(treeSelectionListener);
        JScrollPane scrollPane = new JScrollPane(tree);
        add(scrollPane);
    }

    /** Add child to the currently selected node. */
    public DefaultMutableTreeNode addObject(Object child) {
        DefaultMutableTreeNode parentNode = null;
        TreePath parentPath = tree.getSelectionPath();

        if (parentPath == null) {
            parentNode = rootNode;
        } else {
            parentNode = (DefaultMutableTreeNode)
                         (parentPath.getLastPathComponent());
        }

        return addObject(parentNode, child, true);
    }

    public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
                                            Object child) {
        return addObject(parent, child, false);
    }

    public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
                                            Object child, 
                                            boolean shouldBeVisible) {
        DefaultMutableTreeNode childNode = 
                new DefaultMutableTreeNode(child);

        if (parent == null) {
            parent = rootNode;
        }
	
	//It is key to invoke this on the TreeModel, and NOT DefaultMutableTreeNode
        treeModel.insertNodeInto(childNode, parent, 
                                 parent.getChildCount());

        //Make sure the user can see the lovely new node.
        if (shouldBeVisible) {
            tree.scrollPathToVisible(new TreePath(childNode.getPath()));
        }
        return childNode;
    }

    class MyTreeModelListener implements TreeModelListener {
        public void treeNodesChanged(TreeModelEvent e) {
            DefaultMutableTreeNode node;
            node = (DefaultMutableTreeNode)(e.getTreePath().getLastPathComponent());

            /*
             * If the event lists children, then the changed
             * node is the child of the node we've already
             * gotten.  Otherwise, the changed node and the
             * specified node are the same.
             */

                int index = e.getChildIndices()[0];
                node = (DefaultMutableTreeNode)(node.getChildAt(index));

            System.out.println("New value: " + node.getUserObject());
        }
        public void treeNodesInserted(TreeModelEvent e) {
        }
        public void treeNodesRemoved(TreeModelEvent e) {
        }
        public void treeStructureChanged(TreeModelEvent e) {
        }
    }
}
