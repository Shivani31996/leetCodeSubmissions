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
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        pathP = new ArrayList<>();
        pathQ = new ArrayList<>();
        
        helper(root,p,q,new ArrayList<>());
        
        for(int i = 0; i < pathP.size();i++)
        {
            if(pathP.get(i) != pathQ.get(i))
                return pathP.get(i - 1);
        }
        
        return null;
    }
    
    public void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path)
    {
        //base
        if(root == null)
            return;
        
        //logic
        //action
        path.add(root);
        if(root == p)
        {
            pathP = new ArrayList<>(path);
            pathP.add(p);
        }
        
        if(root == q)
        {
            pathQ = new ArrayList<>(path);
            pathQ.add(q);
        }
        
        //recurse
        helper(root.left,p,q,path);
        helper(root.right,p,q,path);
        
        //backtrack
        path.remove(path.size() - 1);
    }
}