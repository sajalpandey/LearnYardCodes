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
    public void inorder(TreeNode root, ArrayList<Integer> arr) {
        if(root != null) {
            inorder(root.left, arr);
            arr.add(root.val);
            inorder(root.right, arr);
        }
    }
    public TreeNode constructBST(ArrayList<Integer> nums, int l, int h) {
        if(l > h)
            return null;
        int mid = (l+h)/2;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = constructBST(nums, l, mid-1);
        root.right = constructBST(nums, mid+1, h);

        return root;
    }
    
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        
        return constructBST(arr, 0, arr.size()-1);
    }
}