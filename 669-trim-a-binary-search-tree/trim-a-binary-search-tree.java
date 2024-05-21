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
    public TreeNode deleteNode(TreeNode root, int val) {
        System.out.println("val = "+val);
        if (root == null) {
            return root;
        }

        //if root is having only one child left OR right
        if(root.left == null)
            return root.right;
        else if(root.right == null)
            return root.left;
        //if root is having both left AND right child
        //then replace root with min from right sub tree;
        root.val = minValue(root.right);
        root.right = deleteNode(root.right, root.val);
        return root;
    }
    int minValue(TreeNode root) {
        int minv = root.val;
        while (root.left != null) {
            minv = root.left.val;
            root = root.left;
        }
        System.out.println("min value = "+minv);
        return minv;
    }
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null)
            return null;
        System.out.println("trimBST = "+root.val);
        
        if(root!= null && root.left != null)
            root.left = trimBST(root.left, low, high);
        if(root!= null && root.right != null)
            root.right = trimBST(root.right, low, high);
        if(root.val < low || root.val > high) {
            root = deleteNode(root, root.val);
            root = trimBST(root, low, high);
        }
        return root;
    }
}