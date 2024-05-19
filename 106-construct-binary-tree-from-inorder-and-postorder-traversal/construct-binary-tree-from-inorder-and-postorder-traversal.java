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
    public TreeNode buildTreeHelper(int[] inorder, int[] postorder, int is, int ie, int ps, int pe) {
        if(ps > pe || is > ie)
            return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int nodeCountLeft = 0, i = is;
        while(inorder[i] != postorder[pe]) {
            nodeCountLeft++;
            i++;
        }

        //Inorder
        //LeftSubTree "is" to "i-1"
        //RightSubTree "i+1" to "ie"

        //PostOrder
        //LeftSubTree "ps" to "ps+nodeCountLeft-1";
        //RightSubTree "ps+nodeCountLeft" to "pe-1";

        root.left = buildTreeHelper(inorder, postorder, is, i-1, ps, ps+nodeCountLeft-1);
        root.right = buildTreeHelper(inorder, postorder, i+1, ie, ps+nodeCountLeft, pe-1);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeHelper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
}