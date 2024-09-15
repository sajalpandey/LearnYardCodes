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
    public void markParent(TreeNode root, HashMap<TreeNode, TreeNode> parent) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            if(temp.left != null) {
                parent.put(temp.left, temp);
                q.add(temp.left);
            }
            if(temp.right != null) {
                parent.put(temp.right, temp);
                q.add(temp.right);
            }
        }
        return;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        markParent(root, parent);
        /**
        Now we will do BFS in up, left ,right directions
         */
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        int dist = 0;
        q.add(target);
        visited.put(target, true);
        while(!q.isEmpty()) {
            if(dist == k)
                break;
            int size = q.size();
            while(size -- > 0) {
                TreeNode node = q.poll();
                //left
                if(node.left != null && !visited.containsKey(node.left)) {
                    q.add(node.left);
                    visited.put(node.left, true);
                }
                //right
                if(node.right != null && !visited.containsKey(node.right)) {
                    q.add(node.right);
                    visited.put(node.right, true);
                }
                //upward
                if(parent.get(node) != null && !visited.containsKey(parent.get(node))) {
                    q.add(parent.get(node));
                    visited.put(parent.get(node), true);
                }
            }
            dist++;
        }
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()) {
            result.add(q.poll().val);
        }
        return result;
    }
}