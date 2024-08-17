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
    int maxlevel = Integer.MIN_VALUE;
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        depth(root,1);
        return maxlevel;
    }
    
    private void depth(TreeNode root,int level)
    {
        //base
        if(root == null)
            return;
        if(root.left == null && root.right == null)
        {
            if(level > maxlevel)
            {
                maxlevel = level;
            }
        }
        
        //logic
        depth(root.left,level+1);
        depth(root.right,level+1);
    }
}