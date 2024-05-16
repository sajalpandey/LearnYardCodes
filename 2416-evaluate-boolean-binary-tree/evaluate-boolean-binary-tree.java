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
    public int helper(TreeNode root) {
        if(root.left == null && root.right == null) {
            return root.val;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int value = 0;
        if(root.val == 3)
            value = left*right;
        else if(root.val == 2)
            value = (left == 1 || right == 1 ? 1 : 0);
        
        root.val = value;
        return value;
    }
    public boolean evaluateTree(TreeNode root) {
        helper(root);
        return (root.val == 1 ? true : false);
    }
}