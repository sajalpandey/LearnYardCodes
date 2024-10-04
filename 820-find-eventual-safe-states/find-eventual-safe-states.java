class Solution {
    int[] vis, pathVis;
    List<List<Integer>> adj;
    public boolean dfs(int src, List<List<Integer>> adj, List<Integer> result) {
        vis[src] = 1;
        pathVis[src] = 1;
        
        for(int nb : adj.get(src)) {
            if(vis[nb] == 0) {
                if(dfs(nb, adj, result) == false)
                    return false;
            } else if(pathVis[nb] == 1)
                return false;
        }
        
        result.add(src);
        pathVis[src] = 0;
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        vis = new int[V];
        pathVis = new int[V];
        
        List<Integer> result = new ArrayList<>();
        adj = new ArrayList<>();

        for(int i=0; i<V; i++)
            adj.add(new ArrayList<>());
        
        //create adjacency list
        for(int i=0; i<V; i++) {
            for(int j=0; j<graph[i].length; j++) 
                adj.get(i).add(graph[i][j]);
        }
        for(int i=0; i<V; i++) {
            if(vis[i] == 0) {
                dfs(i, adj, result);
            }
        }
        Collections.sort(result);
        return result;
    }
}