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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if((p != null && q == null) || (q != null && p == null))
            return false;
        return ((p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null || root == null)
            return false;
        if(isSameTree(root, subRoot))
            return true;
        return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));   
    }
}