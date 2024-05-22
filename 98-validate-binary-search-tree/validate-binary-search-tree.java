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
class Trio {
    boolean isBST;
    int maxVal;
    int minVal;
    Trio(boolean a, int mx, int mn) {
        isBST = a;
        maxVal = mx;
        minVal = mn;
    }
}
class Solution {
    public Trio bstHelper(TreeNode root) {
        if(root == null) {
            return new Trio(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        //find left subtree max
        Trio leftSubTree = bstHelper(root.left);
        //find right subtree min
        Trio rightSubTree = bstHelper(root.right);
        boolean isBST = true;
        if(root.val > leftSubTree.maxVal && root.val < rightSubTree.minVal) {
            isBST = true;
        }

        leftSubTree.isBST = root.left != null ? (leftSubTree.isBST == true && root.val > leftSubTree.maxVal) : true;
        rightSubTree.isBST = root.right != null ? (rightSubTree.isBST == true && root.val < rightSubTree.minVal) : true;
        isBST = leftSubTree.isBST && rightSubTree.isBST;

        int currNodeMax = Math.max(root.val, Math.max(leftSubTree.maxVal, rightSubTree.maxVal));
        int currNodeMin = Math.min(root.val, Math.min(leftSubTree.minVal, rightSubTree.minVal));

        return new Trio(isBST, currNodeMax, currNodeMin);

    }
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return true;
        return bstHelper(root).isBST;
    }
}