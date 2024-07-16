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
    public TreeNode lowestCommonAncestor(TreeNode root, int s, int t) {
        if(root == null || root.val == s || root.val == t)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, s, t);
        TreeNode right = lowestCommonAncestor(root.right, s, t);

        if(left == null)
            return right;
        if(right == null)
            return left;
        return root;
    }
    public String searchNode(TreeNode root, int s, StringBuilder temp) {
        if(root == null)
            return null;
        else if(root.val == s)
            return temp.toString();
        String left = searchNode(root.left, s, temp.append('L'));
        temp.deleteCharAt(temp.length() - 1);
        String right = searchNode(root.right, s, temp.append('R'));
        temp.deleteCharAt(temp.length() - 1);
        if(left != null)
            return left;
        return right;
    }
    public String getDirections(TreeNode root, int s, int t) {
        TreeNode lca = lowestCommonAncestor(root, s, t);
        String leftStr = searchNode(lca, s, new StringBuilder());
        String rightStr = searchNode(lca, t, new StringBuilder());
        // System.out.println("LCA = "+lca.val);
        // System.out.println("leftStr = "+leftStr);
        // System.out.println("rightStr = "+rightStr);
        StringBuilder p = new StringBuilder();
        for(int i=0; i<leftStr.length(); i++)
            rightStr = 'U' + rightStr;
        return rightStr;
    }
}