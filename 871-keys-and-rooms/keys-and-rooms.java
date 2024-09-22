class Solution {
    List<List<Integer>> adj;
    boolean vis[];
    public void dfs(int src, List<List<Integer>> adj, boolean vis[]) {
        vis[src] = true;
        for(int nb : adj.get(src)) {
            if(vis[nb] == true)
                continue;
            dfs(nb, adj, vis);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        vis = new boolean[n];
        Arrays.fill(vis, false);
        vis[0] = true;
        adj = new ArrayList<>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        for(int i=0; i<n; i++) {
            for(int j=0; j<rooms.get(i).size(); j++) {
                adj.get(i).add(rooms.get(i).get(j));
            }
        }

        dfs(0, adj, vis);
        for(boolean val : vis)
            if(val == false)
                return false;
        return true;
    }
}