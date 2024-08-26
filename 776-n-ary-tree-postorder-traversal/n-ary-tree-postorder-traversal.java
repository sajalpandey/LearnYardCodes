/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> result;
    public void printPostOrder(Node root) {
        if(root != null) {
            for(Node node : root.children) {
                printPostOrder(node);
            }
            if(root != null)
                result.add(root.val);
        }
    }
    public List<Integer> postorder(Node root) {
        result = new ArrayList<>();
        printPostOrder(root);
        return result;
    }
}