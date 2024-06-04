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
    int maxLength;
    public int longestUnivaluePathHelper(TreeNode root) {
        if(root == null)
            return 0;

        int leftValue = 0, rightValue = 0;
        //find left univalue
        if(root.left != null)
            leftValue = longestUnivaluePathHelper(root.left);
        //find right univalue
        if(root.right != null)
            rightValue = longestUnivaluePathHelper(root.right);

        //if root.left val is equal to root.val means increase by 1
        //otherwise for this node from left its zero
        //same for right 
        if(root.left != null && root.val == root.left.val)
            leftValue++;
        else
            leftValue = 0;

        if(root.right != null && root.val == root.right.val)
            rightValue++;
        else
            rightValue = 0;
        
        maxLength = Math.max(maxLength, (leftValue + rightValue));

        return Math.max(leftValue, rightValue);


    }
    public int longestUnivaluePath(TreeNode root) {
        maxLength = 0;
        longestUnivaluePathHelper(root);
        return maxLength;
    }
}