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
    public int rangeSumBST(TreeNode root, int low, int high) {
        //base
        if(root == null)
        {
            return 0;
        }

        //logic
        int left = rangeSumBST(root.left, low, high);
        int right = rangeSumBST(root.right, low, high);

        if(root.val >= low && root.val <= high)
        {
            return left+right+root.val;
        }
        return left+right;
    }
}