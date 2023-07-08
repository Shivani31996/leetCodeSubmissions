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
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root,new ArrayList<>(), targetSum, 0);
        return result;
    }
    
    private void helper(TreeNode root, List<Integer> path, int target, int currSum)
    {
        //base
        if(root == null)
            return;
        //logic
        //action
        currSum += root.val;
        path.add(root.val);
        
        //recurse
        helper(root.left,new ArrayList<>(path),target,currSum);
        helper(root.right,new ArrayList<>(path),target,currSum);
        
        if(root.left == null && root.right == null)
        {
            if(currSum == target)
            {
                result.add(new ArrayList<>(path));
            }
        }
        
        path.remove(path.size() - 1);
    }
}