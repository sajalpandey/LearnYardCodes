class Solution {
    List<List<Integer>> adj;
    boolean[] visited;
    public void dfs(int curr) {
        visited[curr] = true;
        for(int nb : adj.get(curr)) {
            if(visited[nb] == true)
                continue;
            dfs(nb);
        }
    }

    public void bfs(int curr) {
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        visited[curr] = true;
        while(!q.isEmpty()) {
            int node = q.poll();
            for(int nb : adj.get(node)) {
                if(visited[nb] == true)
                    continue;
                q.add(nb);
                visited[nb] = true;
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
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
        
        // We will start DFS from source
        // if dest is reachable from source it will be marked as true in visited array
        //dfs(source);

        // Either we can do BFS from source and check the same
        bfs(source);

        return visited[destination];
    }
}