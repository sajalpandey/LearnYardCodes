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
    int totalSum = 0;
    public void helper(TreeNode root) {
        if(root == null)
            return;
        helper(root.right);

        root.val += totalSum;
        totalSum = root.val;

        helper(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        helper(root);
        return root;
    }
}