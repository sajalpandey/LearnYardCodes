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
    int maxSum;
    //{isBST(1,0),largest, smallest, sum}
    public int[] maxSumBSTHelper(TreeNode root) {
        if(root == null) {
            return new int[] {1, Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }
        int[] leftSubTree = maxSumBSTHelper(root.left);
        int[] rightSubTree = maxSumBSTHelper(root.right);
        int isBST = 0;
        if(leftSubTree[0] == 1 && rightSubTree[0] == 1 && root.val > leftSubTree[1] && root.val < rightSubTree[2])
            isBST = 1;
        int sum = 0;
        if(isBST == 1) {
            sum = root.val + leftSubTree[3] + rightSubTree[3];
            maxSum = Math.max(maxSum, sum);
        }
        return new int[] {isBST, Math.max(root.val, Math.max(leftSubTree[1],rightSubTree[1])), Math.min(root.val, Math.min(leftSubTree[2],rightSubTree[2])),sum};
    }
    public int maxSumBST(TreeNode root) {
        maxSum = 0;
        maxSumBSTHelper(root);
        return maxSum;
    }
}