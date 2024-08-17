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
    int minLevel = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        helper(root,1);
        return minLevel;
    }
    
    private void helper(TreeNode root, int level)
    {
        //base
        if(root == null)
            return;
        if(root.left == null && root.right == null)
        {
            if(level < minLevel)
                minLevel = level;
        }
        
        //logic
        helper(root.left,level+1);
        helper(root.right,level+1);
    }
}