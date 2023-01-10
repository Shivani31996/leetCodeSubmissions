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
    List<Integer> result;
    public List<Integer> preorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        if(root == null)
            return result;
        dfs(root);
        return result;
    }
    public void dfs(TreeNode root)
    {
        //base
        if(root == null)
            return;
        //logic
        result.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}