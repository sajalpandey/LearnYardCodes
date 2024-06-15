class Solution {
    List<List<Integer>> adj;
    int[] vis;
    public boolean dfs(int curr, List<Integer> st) {
        //mark this node in progress
        vis[curr] = 1;

        //visit its neighbour
        for(int nb : adj.get(curr)) {
            //if its un-visited ==> call DFS
            if(vis[nb] == 0) {
                boolean possible = dfs(nb, st);
                if(!possible)
                    return false;
            } else if(vis[nb] == 1) {
                //found a neighbour which is already in dfs process ==> back edge
                //cycle detected
                return false;
            }
        }
        //now mark parent as visited
        vis[curr] = 2;
        st.add(curr);
        return true;
    }
    public List<Integer> topoSortDfs(int n) {
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack();
        for(int i=0; i<n; i++) {
            if(vis[i] == 0) {
                boolean possible = dfs(i, ans);
                // if(!possible)
                //     return ans;
            }
        }
        Collections.sort(ans);
        return ans;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        adj = new ArrayList<>();
        vis = new int[n];

        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        
        //create adjacency list
        for(int i=0; i<n; i++) {
            for(int j=0; j<graph[i].length; j++) 
                adj.get(i).add(graph[i][j]);
        }

        return topoSortDfs(n);
    }
}