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
    boolean flag = false;
    public boolean hasPathSum(TreeNode root, int target) {
        if(root == null)
            return false;
        helper(root,target,0);
        return flag;
    }
    
    private void helper(TreeNode root, int target,int currSum)
    {
        //base
        if(root == null)
        {
            return;
        }
        
        //logic
        currSum += root.val;
        if(root.left == null && root.right == null)
        {
            if(currSum == target)
            {
                flag = true;
            }
        }
        helper(root.left,target,currSum);
        helper(root.right,target,currSum);
    }
}