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
    public void pathSumHelper(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> temp) {
        System.out.println("targetSum = "+targetSum);
        if(root == null)
            return;
        if(targetSum == root.val && root.left == null && root.right == null) {
            temp.add(root.val);
            result.add(new ArrayList<>(temp));
            if(!temp.isEmpty())
                temp.remove(temp.size()-1);
            return;
        }
        
        //serach on left side
        temp.add(root.val);
        //targetSum = targetSum-root.val
        pathSumHelper(root.left, targetSum-root.val, result, temp);
        //serach on right side
        pathSumHelper(root.right, targetSum-root.val, result, temp);
        if(!temp.isEmpty())
            temp.remove(temp.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        pathSumHelper(root, targetSum, result, temp);
        return result;
    }
}