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
    List<String> ans;
    public void helper(TreeNode root, String str) {
        if(root == null)
            return;
        str += root.val;
        if(root.left == null && root.right == null) {
            //means its a leaf node
            ans.add(str);
            return;
        }
        str += "->";
        if(root.left != null)
            helper(root.left, str);
        if(root.right != null)
            helper(root.right, str);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        helper(root, "");
        return ans;
    }
}