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
    TreeNode node;
    int hd;

    Pair(TreeNode node, int value) {
        this.node = node;
        this.hd = value;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        if(root == null)
            return result;
        q.add(new Pair(root, 0));
        // map.putIfAbsent(0, new ArrayList<>());
        // map.get(0).add(root.val);
        
        while(!q.isEmpty()) {
            int size = q.size();
            TreeMap<Integer, List<Integer>> tmpMap = new TreeMap<>();
            while(size-- > 0) {
                Pair temp = q.poll();
                int val = temp.hd;
                TreeNode curr = temp.node;
                tmpMap.putIfAbsent(val, new ArrayList<>());
                tmpMap.get(val).add(curr.val);

                if(curr.left != null)
                    q.add(new Pair(curr.left, val-1));

                if(curr.right != null)
                    q.add(new Pair(curr.right, val+1));
            }
            for(int key : tmpMap.keySet()) {
                List<Integer> list = tmpMap.get(key);
                Collections.sort(list);
                
                // Merge the contents of tmpMap into map
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).addAll(list);
            }
            // for(int key : tmpMap.keySet()) {
            //     map.putIfAbsent(key, new ArrayList<>());
            //     map.get(val).add(map.get(key));
            // }
            
        }
        for(List<Integer> list : map.values()) {
            //Collections.sort(list);
            result.add(list);
        }
        return result;
    }
}