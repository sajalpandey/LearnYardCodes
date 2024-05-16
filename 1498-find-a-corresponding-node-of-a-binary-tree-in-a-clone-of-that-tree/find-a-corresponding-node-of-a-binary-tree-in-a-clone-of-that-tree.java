/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode helper(TreeNode cloned, TreeNode target) {
        if(cloned != null) {
            if(cloned.val == target.val) {
                //System.out.println("sajal");
                return cloned;
            }
            TreeNode leftFound = helper(cloned.left, target);
            if(leftFound != null)
                return leftFound;
            return helper(cloned.right, target);
        }
        return null;
    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return helper(cloned, target);
    }
}