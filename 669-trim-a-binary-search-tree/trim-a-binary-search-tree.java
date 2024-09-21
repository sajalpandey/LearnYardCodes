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
    public TreeNode findMax(TreeNode root) {
        while(root.right != null)
            root = root.right;
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        if(root.val == key) {
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            TreeNode maxNode = findMax(root.left);
            root.val = maxNode.val;
            root.left = deleteNode(root.left, root.val);
        }  
        else if(root.val < key)
            root.right = deleteNode(root.right, key);
        else 
            root.left = deleteNode(root.left, key);
        return root;
    }
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null)
            return root;
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        if(root.val < low || root.val > high)
            root = deleteNode(root, root.val);
        return root;
    }
}