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
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        result = new ArrayList<>();
        if(root == null)
            return result;
        
        helper(root, target, new ArrayList<>(), 0);
        return result;
    }
    
    private void helper(TreeNode root, int target, List<Integer> path, int currSum)
    {
        //base
        if(root == null)
            return;
        
        //logic
        currSum += root.val;
        path.add(root.val);
        
        helper(root.left, target, path, currSum);
        if(root.left == null && root.right == null)
        {
            if(currSum == target)
            {
                result.add(new ArrayList<>(path));
            }
        }
        helper(root.right,target, path, currSum);
        path.remove(path.size() - 1);
        
    }
}