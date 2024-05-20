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
    public void reverseInorder(TreeNode root, int[] sum) {
        if (root == null)
            return;
        reverseInorder(root.right, sum);
        int temp = root.val;
        root.val+=sum[0];
        sum[0]+=temp;
        reverseInorder(root.left, sum);
    }
    public TreeNode bstToGst(TreeNode root) {
        //We can use reverse inorder traversal
        int[] sum = new int[1];
        reverseInorder(root, sum);
        return root;
        
    }
}