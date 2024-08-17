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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Double> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        q.add(root);
        
        while(!q.isEmpty())
        {
            double size = q.size();
            double sum = 0;
            double avg = 0;
            for(int i = 0; i < size; i++)
            {
                TreeNode curr = q.poll();
                sum += curr.val;
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
            avg = sum/size;
            result.add(avg);
        }
        
        return result;
    }
}