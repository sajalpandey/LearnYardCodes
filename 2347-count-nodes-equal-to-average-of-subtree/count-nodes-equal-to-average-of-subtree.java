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

class Pair {
    int sum;
    int count;
    Pair(int sum, int count) {
        this.sum = sum;
        this.count = count;
    }
}
class Solution {
    int result = 0;
    public Pair helper(TreeNode root) {
        if(root == null)
            return new Pair(0,0);
        
        Pair leftSubtree = helper(root.left);
        Pair rightSubtree = helper(root.right);
        int sum = root.val + leftSubtree.sum + rightSubtree.sum;
        int count = 1 + leftSubtree.count + rightSubtree.count;
        
        if((sum/count) ==  root.val)
            result++;
        return new Pair(sum, count);
    }
    public int averageOfSubtree(TreeNode root) {
        result = 0;
        helper(root);
        return result;
    }
}