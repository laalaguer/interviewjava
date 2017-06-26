/**
* @author Xiqing chu
*/

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
public class SolutionTest {
    @Test
    public void fullTree01(){
        ArrayList<TreeNode> t = new ArrayList<TreeNode>();
        t.add(new TreeNode(1));
        t.add(new TreeNode(2));
        t.add(new TreeNode(3));
        t.add(new TreeNode(4));
        t.add(new TreeNode(5));
        t.add(new TreeNode(6));
        t.add(new TreeNode(7));
        
        assertEquals("[1, 2, 3, 4, 5, 6, 7]", Arrays.toString(t.toArray()));
        TreeNode root = this.buildTree(t); // build a tree
        Solution s = new Solution();
        TreeNode newRoot = s.invertTree(root);
        ArrayList<TreeNode> t2 = this.flatternTree(newRoot); // flattern the tree
        assertEquals("[1, 3, 2, 7, 6, 5, 4]", Arrays.toString(t2.toArray()));
    }

    @Test
    public void fullTree02(){
        ArrayList<TreeNode> t = new ArrayList<TreeNode>();
        t.add(new TreeNode(1));
        t.add(new TreeNode(2));
        t.add(new TreeNode(3));
        t.add(new TreeNode(4));
        t.add(new TreeNode(5));
        t.add(new TreeNode(6));
        assertEquals("[1, 2, 3, 4, 5, 6]", Arrays.toString(t.toArray()));
        TreeNode root = this.buildTree(t); // build a tree
        Solution s = new Solution();
        TreeNode newRoot = s.invertTree(root);
        ArrayList<TreeNode> t2 = this.flatternTree(newRoot); // flattern the tree
        assertEquals("[1, 3, 2, 6, 5, 4]", Arrays.toString(t2.toArray()));
    }

    /**
     * Build a tree from a BFS ArrayList
     * Return the root of the tree that has been built.
     * If arraylist empty, then return null.
     * */
    public TreeNode buildTree(ArrayList<TreeNode> nodes){
        // if empty arraylist
        if (nodes.size() == 0){
            return null;
        }
        // else
        TreeNode root = nodes.get(0);
        // Structure the tree
        for (int i = 0; i < nodes.size(); i++){
            if ((2*i+1) < nodes.size()){
                nodes.get(i).left = nodes.get(2*i+1);
            } else {
                nodes.get(i).left = null;
            }
            if ((2*i+2) < nodes.size()){
                nodes.get(i).right = nodes.get(2*i+2);
            } else {
                nodes.get(i).right = null;
            }
        }
        
        return root;
    }

    /** 
     * Build an ArrayList of nodes, from a Tree
     * Nodes are added to ArrayList using BFS travel method
     * If the input tree is empty, then return null, otherwise return an ArrayList
    */
    public ArrayList<TreeNode> flatternTree(TreeNode root){
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        ArrayList<TreeNode> returnList = new ArrayList<TreeNode>();
        // if empty tree
        if (root == null){
            return null;
        }
        // else
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode obj = queue.get(0);
            returnList.add(obj);
            if (obj.left != null){
                queue.add(obj.left);
            }
            if (obj.right != null){
                queue.add(obj.right);
            }
            queue.remove(0);
        }
        return returnList;
    }
}