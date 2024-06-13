class Solution {
    List<List<Integer>> adj, res;
    boolean[] vis;
    public void dfs(int curr, List<Integer> temp, int n) {
        temp.add(curr);
        if(curr == n-1) {
            res.add(new ArrayList<>(temp));
        }

        //now call dfs for every neighbour
        for(int nb : adj.get(curr)) {
            dfs(nb, temp, n);
        }
        //then backtrack
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new ArrayList<>();
        int n = graph.length;
        adj = new ArrayList<>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        for(int i=0; i<n; i++) {
            for(int j=0; j<graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }
        List<Integer> temp = new ArrayList<>();
        
        dfs(0, temp, n);
        return res;

    }
}