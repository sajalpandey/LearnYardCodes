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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashMap<Integer, Boolean> rootMap = new HashMap<>();
        for(int i=0; i<descriptions.length; i++) {
            rootMap.put(descriptions[i][0], true);
            rootMap.put(descriptions[i][1], true);
        }
        for(int i=0; i<descriptions.length; i++) {
            int parent = descriptions[i][0];
            int child = descriptions[i][1];
            rootMap.put(child, false);
            int isLeft = descriptions[i][2];
            TreeNode root = null;
            TreeNode c = null;
            if(map.containsKey(parent)) {
                root = map.get(parent);
            } else {
                root = new TreeNode(parent);
                map.put(parent, root);
            }
            if(map.containsKey(child)) {
                c = map.get(child);
            } else {
                c = new TreeNode(child);
                map.put(child, c);
            }

            if(isLeft == 1) {
                root.left = c;
            } else
                root.right = c;
        }

        for(int parent : rootMap.keySet()) {
            if(rootMap.get(parent) == true) {
                return map.get(parent);
            }
        }
        return null;
    }
}