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
    public int isBalancedHelper(TreeNode root) {
        if(root == null)
            return 0;
        int leftHeight = isBalancedHelper(root.left);
        int rightHeight = isBalancedHelper(root.right);

        if(leftHeight == -1 || rightHeight == -1)
            return -1;

        if(Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return (1 + Math.max(isBalancedHelper(root.left), isBalancedHelper(root.right)));
        
    }
    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root) == -1 ? false : true;
    }
}