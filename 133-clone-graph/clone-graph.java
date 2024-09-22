/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
/**
    For each node in original graph we need to create a copy node
    now for each original node add entry of original --> copy in map(used later)
    Now for each original node find its neighbour
    and add these neighbours as neighbours of copy node
    if neighbours entry found in map , add from it otherwise call clone for that
 */
class Solution {
    HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null)
            return node;
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        for(Node ngh : node.neighbors) {
            if(map.containsKey(ngh)) {
                copyNode.neighbors.add(map.get(ngh));
            } else {
                copyNode.neighbors.add(cloneGraph(ngh));
            }
        }
        return copyNode;
    }
}