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
    int result;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return result;
    }
    
    private void helper(TreeNode root, int curr)
    {
        //base
        if(root == null)
            return;
        
        //logic
        helper(root.left, curr*10 + root.val);
        //st.pop();
        if(root.left == null && root.right == null)
        {
            result += curr*10 + root.val;
        }
        
        helper(root.right, curr*10 + root.val);
        //st.pop();
    }
}