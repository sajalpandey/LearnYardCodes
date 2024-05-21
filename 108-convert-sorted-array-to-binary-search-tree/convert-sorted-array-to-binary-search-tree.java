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
    public TreeNode bstHelper(int[] nums, int l, int h) {
        if(l > h)
            return null;
        int mid = (l+h)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = bstHelper(nums, l, mid-1);
        root.right = bstHelper(nums, mid+1, h);

        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return bstHelper(nums, 0, nums.length-1);
    }
}