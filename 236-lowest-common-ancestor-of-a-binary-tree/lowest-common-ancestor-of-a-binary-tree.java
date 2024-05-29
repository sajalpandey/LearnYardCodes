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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //if root is null OR root is equal to p OR root is equal to q
        //means root is our lca

        if(root == null || root == p || root == q)
            return root;
        
        //Now try to find lca in left & right
        //if both nodes are present in different subtree means
        //root is out lca (bifurcation point)
        //if left is null means both are present in right vice versa

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null)
            return right;
        else if(right == null)
            return left;
        else
            return root;
    }
}