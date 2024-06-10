class Solution {
    List<List<Integer>> adj;
    boolean[] visited;
    long nodes;

    public void dfs(int curr) {
        nodes++;
        visited[curr] = true;
        for(int nb : adj.get(curr)) {
            if(visited[nb] == true)
                continue;
            dfs(nb);
        }
    }
    public long countPairs(int n, int[][] edges) {
        visited = new boolean[n];
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
        ArrayList<Integer> cycles = new ArrayList<>();
        long sum = ((long)n*(n-1)/2);
        for(int i=0; i<n; i++) {
            if(visited[i] == false) {
                nodes = 0;
                dfs(i);
                sum -= (nodes * (nodes-1))/2;
            }
        }
        
        return sum;
    }
}