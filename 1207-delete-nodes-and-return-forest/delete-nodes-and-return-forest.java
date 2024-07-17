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
    public TreeNode postOrder(TreeNode root, List<TreeNode> result, HashSet<Integer> set) {
        if(root == null) {
            return root;
        }
        root.left = postOrder(root.left, result, set);
        root.right = postOrder(root.right, result, set);

        if(set.contains(root.val)) {
            //this node needs to be deleted
            if(root.left != null)
                result.add(root.left);
            if(root.right != null)
                result.add(root.right);
            return null;
        }

        return root;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> set = new HashSet<>();
        List<TreeNode> result = new ArrayList<>();
        for(int ele : to_delete)
            set.add(ele);
        if(!set.contains(root.val))
            result.add(root);
        postOrder(root, result, set);
        return result;
    }
}