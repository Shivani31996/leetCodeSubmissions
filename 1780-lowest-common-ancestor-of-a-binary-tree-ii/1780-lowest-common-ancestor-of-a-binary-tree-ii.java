/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private boolean pFound = false;
    private boolean qFound = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = dfs(root, p, q);
        
        if(pFound && qFound)
        {
            return lca;
        }
        return null;
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q)
    {
        //base
        if(root == null)
        {
            return null;
        }

        //logic
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);

        if(root == p)
        {
            pFound = true;
            return root;
        }

        if(root == q)
        {
            qFound = true;
            return root;
        }

        if(left != null && right != null)
        {
            return root;
        }
        else if(left != null)
        {
            return left;
        }
        return right;
    }
}