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
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        adj = new ArrayList<>();
        int n = rooms.size();
        for(int i=0; i<n ;i++)
            adj.add(new ArrayList<>());
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<rooms.get(i).size(); j++) {
                int p = rooms.get(i).get(j);
                if(i == p)
                    continue;
                adj.get(i).add(p);
                //adj.get(p).add(i);
            }
        }
        visited = new boolean[n];
        Arrays.fill(visited, false);
        dfs(0);
        for(int i=0; i<n; i++)
            if(visited[i] == false)
                return false;
        return true;
    }
}