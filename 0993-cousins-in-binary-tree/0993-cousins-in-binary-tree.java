/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    int xLevel = 0;
    int yLevel = 0;
    TreeNode x_parent;
    TreeNode y_parent;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;
        dfs(root,null,x, y, 0);
        
        if(xLevel == yLevel && x_parent != y_parent)
            return true;
        return false;
    }
    
    private void dfs(TreeNode root, TreeNode parent, int x, int y, int level)
    {
        //base
        if(root == null)
        {
            return;
        }
        
        //logic
        if(root.val == x)
        {
            xLevel = level;
            x_parent = parent;
        }
        if(root.val == y)
        {
            yLevel = level;
            y_parent = parent;
        }
        
        dfs(root.left,root,x,y,level+1);
        dfs(root.right,root,x,y,level+1);
    }
}