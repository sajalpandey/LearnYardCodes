class Solution {
    ArrayList<ArrayList<Integer>>adj;
    int[] color;
    public boolean dfs(ArrayList<ArrayList<Integer>>adj, int src, int c) {
        color[src] = c;
        
        //traverse neightbour
        for(int nb : adj.get(src)) {
            if(color[nb] == -1) {
                if(dfs(adj, nb, 1-c) == false)
                    return false;
            } else if(color[nb] == c)
                return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] edges) {
        int n = edges.length;
        color = new int[n];
        Arrays.fill(color, -1);
        adj = new ArrayList<>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        for(int i=0; i<edges.length; i++) {
            for(int j=0; j<edges[i].length; j++) {
                int p = edges[i][j];
                adj.get(i).add(p);
                adj.get(p).add(i);
            }
            
        }
        for(int i=0; i<n; i++) {
            if(color[i] == -1)
                if(dfs(adj, i, 0) == false)
                    return false;
        }
        return true;
    }
}