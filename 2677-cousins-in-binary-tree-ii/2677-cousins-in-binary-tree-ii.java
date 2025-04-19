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
        List<Integer> li = new ArrayList<>();
        dfs1(root, 0, li);

        dfs2(root, 0, li);

        return root;
    }

    private void dfs1(TreeNode root, int level, List<Integer> li)
    {
        //base
        if(root == null)
        {
            return;
        }

        //logic
        if(li.size() == level)
        {
            li.add(0);
        }
        li.set(level, li.get(level)+root.val);

        dfs1(root.left, level+1, li);
        dfs1(root.right, level+1, li);
    }

    private void dfs2(TreeNode root, int level, List<Integer> li)
    {
        //base
        if(root == null)
        {
            return;
        }

        //logic
        root.val = li.get(level) - root.val;
        int childrenSum = 0;
        if(root.left != null)
        {
            childrenSum += root.left.val;
        }

        if(root.right != null)
        {
            childrenSum += root.right.val;
        }
        if(root.left != null)
        {
            root.left.val = childrenSum;
        }
        if(root.right != null)
        {
            root.right.val = childrenSum;
        }

        dfs2(root.left, level+1, li);
        dfs2(root.right, level+1, li);
    }


}