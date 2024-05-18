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
    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        if(is > ie || ps > pe )
            return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int i = is;
        int nodeCountLeft = 0;
        while(inorder[i]  != preorder[ps]) {
            nodeCountLeft++;
            i++;
        }

        //PREORDER leftSubtree start = ps+1
        //PREORDER leftSubTree end = ps+nodeCountLeft
        //PREORDER rightSubTree start = ps+nodeCountLeft+1
        //PREORDER rightSubTree end = pe

        //INORDER leftSubTree start = is
        //INORDER leftSubTree end = i-1
        //INORDER rightSubTree start = i+1
        //INORDER rightSubTree end = ie

        root.left = buildTreeHelper(preorder, inorder, ps+1, ps+nodeCountLeft, is, i-1);
        root.right = buildTreeHelper(preorder, inorder, ps+nodeCountLeft+1, pe, i+1, ie);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
}