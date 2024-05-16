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
    public List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        List<Double> result = new ArrayList<>();
        dq.addFirst(root);
        while(!dq.isEmpty()) {
            int size = dq.size();
            int l = size;
            double temp = 0.0;
            while(size -- > 0) {
                TreeNode node = dq.pollFirst();
                temp += node.val;
                if(node.left != null)
                    dq.addLast(node.left);
                if(node.right != null)
                    dq.addLast(node.right);
            }
            result.add((double)temp/l);
        }
        return result;
    }
}