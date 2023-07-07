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
    public int sumNumbers(TreeNode root) {
        
        int result = 0;
        int currNum = 0;
        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> currNumStack = new Stack<>();
        
        while(root != null || !st.isEmpty())
        {
            while(root != null)
            {
                currNum = currNum*10 + root.val;
                st.push(root);
                currNumStack.push(currNum);
                root = root.left;
            }
            root = st.pop();
            currNum = currNumStack.pop();
            
            if(root.left == null && root.right == null)
            {
                result += currNum;
            }
            root = root.right;
        }
        return result;
    }
}