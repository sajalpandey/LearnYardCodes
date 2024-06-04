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
    int maxD;
    public int helper(TreeNode root) {
        if(root == null)
            return 0;
        int ld = 0, rd = 0;
        if(root.left != null)
            ld = 1 + helper(root.left);
        if(root.right != null)
            rd = 1 + helper(root.right);
        maxD = Math.max(maxD, (ld + rd));

        return Math.max(ld, rd);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        maxD = 0;
        helper(root);
        return maxD;
    }
}