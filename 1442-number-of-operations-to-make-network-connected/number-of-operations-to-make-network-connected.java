class Solution {
    List<List<Integer>> adj;
    boolean[] visited;
    int extraEdges;
    public void dfs(int curr) {
        visited[curr] = true;
        for(int nb : adj.get(curr)) {
            if(visited[nb] == true) {
                extraEdges++;
                continue;
            }
            dfs(nb);
        }
    }
    public int makeConnected(int n, int[][] edges) {
        if(n-1 > edges.length)
            return -1;
        visited = new boolean[n];
        extraEdges = 0;
        Arrays.fill(visited, false);
        adj = new ArrayList<>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        for(int i=0; i<edges.length; i++) {
            int p = edges[i][0];
            int q = edges[i][1];

            adj.get(p).add(q);
            adj.get(q).add(p);
        }
        int ans = 0;
        for(int i=0; i<n; i++) {
            if(visited[i] == false) {
                ans++;
                dfs(i);
            }
        }
        return ans-1;
    }
}