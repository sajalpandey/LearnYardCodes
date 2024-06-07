class Solution {
    List<List<Integer>> adj;
    int[] visited;
    public boolean dfs(int curr, int bit) {
        visited[curr] = bit;
        for(int nb : adj.get(curr)) {
            if(visited[nb] != -1) {
                if(visited[curr] == visited[nb])
                    return false;
                continue;
            }
            //check for every non visited child
            if(dfs(nb, 1^bit) == false)
                return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] edges) {
        int n = edges.length;
        visited = new int[n];
        Arrays.fill(visited, -1);
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
        boolean ans = true;
        for(int i=0; i<n; i++)
            if(visited[i] == -1)
                ans = ans & dfs(i,0);
        return ans;
    }
}