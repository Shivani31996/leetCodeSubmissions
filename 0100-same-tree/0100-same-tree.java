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
    boolean flag = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        helper(p,q);
        return flag;
    }
    
    private void helper(TreeNode p,TreeNode q)
    {
        //base
        if(p == null && q != null)
        {
            flag = false;
            return;
        }
        if(p != null && q == null)
        {
            flag = false;
            return;
        }
        if(p == null && q == null)
        {
            return;
        }
        if(p.val != q.val)
        {
            flag = false;
            return;
        }
        //logic
        helper(p.left,q.left);
        helper(p.right,q.right);
    }
}