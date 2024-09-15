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
    TreeNode root;
    int num;
    Pair(TreeNode root, int num) {
        this.root = root;
        this.num = num;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        int maxW = 0;
        q.add(new Pair(root, 1));
        while(!q.isEmpty()) {
            int size = q.size();
            int x = q.peek().num;
            while(size-- > 0) {
                Pair p = q.poll();
                maxW = Math.max(maxW, (p.num - x));
                if(p.root.left != null)
                    q.add(new Pair(p.root.left, 2*p.num));
                if(p.root.right != null)
                    q.add(new Pair(p.root.right, 2*p.num+1));
            }
        }
        return ++maxW;
    }
}