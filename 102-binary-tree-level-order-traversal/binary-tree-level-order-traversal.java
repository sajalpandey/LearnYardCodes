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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        if(root == null)
            return result;
        dq.push(root);
        while(dq.size() > 0) {
            int size = dq.size();
            List<Integer> ans = new ArrayList<>();
            while(size > 0){
                TreeNode temp = dq.peekFirst();
                dq.pollFirst();
                if(temp.left != null)
                    dq.addLast(temp.left);
                if(temp.right != null)
                    dq.addLast(temp.right);
                ans.add(temp.val);
                size--;
            }
            result.add(new ArrayList<>(ans));
        }
        return result;
    }
}