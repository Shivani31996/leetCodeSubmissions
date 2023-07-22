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
    TreeNode x_parent;
    TreeNode y_parent;
    int x_level;
    int y_level;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;
        
        dfs(root,x,y,null,0);
        if(x_parent != y_parent && x_level == y_level)
            return true;
        else
            return false;
    }
    
    private void dfs(TreeNode root, int x, int y,TreeNode parent, int level)
    {
        //base
        if(root == null)
            return;
        
        //logic
        if(root.val == x)
        {
            x_parent = parent;
            x_level = level;
        }
        
        if(root.val == y)
        {
            y_parent = parent;
            y_level = level;
        }
        
        dfs(root.left,x,y,root,level+1);
        dfs(root.right,x,y,root,level+1);
    }
}