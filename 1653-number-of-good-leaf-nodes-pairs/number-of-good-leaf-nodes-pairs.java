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
    int result = 0;
    public int[] postOrder(TreeNode root, int d) {
        if(root == null)
            return new int[] {0};
        if(root.left == null && root.right == null)
            return new int[] {1};
        
        int[] left = postOrder(root.left, d);
        int[] right = postOrder(root.right, d);
        for(int e1 : left) {
            for(int e2 : right) {
                if(e1!=0 && e2!=0 && (e1+e2) <= d)
                    result++;
            }
        }
        int k = 0;
        int[] arr = new int[left.length+ right.length];
        for(int e1 : left) {
            if(e1!=0 && (e1+1) < d)
                arr[k++] = e1+1;
        }
        for(int e2 : right) {
            if(e2!=0 && (e2+1) < d)
                arr[k++] = e2+1;
        }
        return arr;
    }
    public int countPairs(TreeNode root, int distance) {
        /**
        For each parent find the dist array of each its childeren to left
        similarly dist array of each its childeren to right

        Now iterate over left and right arrays and find 
        if left[i] + right[i] <= d , we can increase our result

        Now merge both distance arrays after incrementing values by 1
        and return it 
         */

        postOrder(root, distance);
        return result;
    }
}