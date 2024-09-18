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
    public TreeNode helper(int[] preorder, int ps, int pe) {
        if(ps > pe)
            return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int maxIdx = ps+1;
        while(maxIdx <= pe && preorder[maxIdx] < root.val) {
            maxIdx++;
        }
        root.left = helper(preorder, ps+1, maxIdx-1);
        root.right = helper(preorder, maxIdx, pe);

        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return  helper(preorder, 0, preorder.length-1);
    }
}