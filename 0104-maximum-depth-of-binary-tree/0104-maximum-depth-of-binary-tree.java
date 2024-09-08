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
    int max = 0;
    public int maxDepth(TreeNode root) {
        dfs(root,1);
        return max;
    }
    
    private void dfs(TreeNode root, int level)
    {
        //base
        if(root == null)
        {
            return;
        }
        if(root.left == null && root.right == null)
        {
            max = Math.max(max,level);
            System.out.println(max);
        }
        
        //logic
        dfs(root.left,level+1);
        System.out.println("Max after left: "+max);
        dfs(root.right,level+1);
        System.out.println("Max after right: "+max);
    }
}