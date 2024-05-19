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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            int rightMostNode = -999;
            while(size-- > 0) {
                TreeNode node = q.peek();
                q.remove();
                //map.put(level, node.val);
                rightMostNode = node.val;
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
            if(rightMostNode != -999)
                result.add(rightMostNode);

        }
        return result;
    }
}