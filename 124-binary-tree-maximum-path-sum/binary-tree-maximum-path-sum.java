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
    int res;
    public int maxPathSumHelper(TreeNode root) {
        if(root == null)
            return 0;
        int leftSum = maxPathSumHelper(root.left);
        int rightSum = maxPathSumHelper(root.right);

        //save max value in our result
        int val1 = root.val+leftSum+rightSum;
        int val2 = root.val+leftSum;
        int val3 = root.val+rightSum;

        res =  Math.max(res, Math.max(root.val, Math.max(val1, Math.max(val2, val3))));

        int returnValue = Math.max(root.val, Math.max(val2, val3));
        return returnValue;
    }
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        maxPathSumHelper(root);
        return res;
    }
}