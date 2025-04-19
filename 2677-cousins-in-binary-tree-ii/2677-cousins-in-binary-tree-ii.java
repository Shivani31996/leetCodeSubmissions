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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> li = new ArrayList<>();

        q.add(root);

        while(!q.isEmpty())
        {
            int levelSum = 0;
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                TreeNode curr = q.poll();
                levelSum += curr.val;

                if(curr.left != null)
                {
                    q.add(curr.left);
                }

                if(curr.right != null)
                {
                    q.add(curr.right);
                }
            }
            li.add(levelSum);
        }

        q.add(root);
        root.val = 0;
        int level = 1;

        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                int siblingSum = 0;
                TreeNode curr = q.poll();

                if(curr.left != null)
                {
                    siblingSum += curr.left.val;
                }
                if(curr.right != null)
                {
                    siblingSum += curr.right.val;
                }

                if(curr.left != null)
                {
                    q.add(curr.left);
                    curr.left.val = li.get(level) - siblingSum;
                }

                if(curr.right != null)
                {
                    q.add(curr.right);
                    curr.right.val = li.get(level) - siblingSum;
                }
            }
            level++;
        }

        return root;
    }
}