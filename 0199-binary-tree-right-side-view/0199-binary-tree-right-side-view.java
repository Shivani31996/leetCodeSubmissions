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
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)
        {
            return result;
        }
        dfs(root,0);
        return result;
    }
    
    private void dfs(TreeNode root, int pos)
    {
        //base
        if(root == null)
            return;
        
        //logic
        if(result.size() == pos)
        {
            result.add(root.val);
        }
        // else
        // {
        //     result.set(pos,root.val);
        // }
        dfs(root.right, pos+1);
        dfs(root.left, pos+1);
    }
}