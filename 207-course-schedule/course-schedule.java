class Solution {
    List<List<Integer>> adj;
    int[] vis;

    public boolean dfs(int curr) {
        //mark this node in progress
        vis[curr] = 1;

        //visit its neighbour
        for(int nb : adj.get(curr)) {
            //if its un-visited ==> call DFS
            if(vis[nb] == 0) {
                boolean possible = dfs(nb);
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

        return true;
    }
    public boolean topoSortDfs(int n) {
        Stack<Integer> st = new Stack();
        for(int i=0; i<n; i++) {
            if(vis[i] == 0) {
                boolean possible = dfs(i);
                if(!possible)
                    return false;
            }
        }
        return true;
    }
    public boolean canFinish(int numCourses, int[][] pre) {
        adj = new ArrayList<>();
        vis = new int[numCourses];
        for(int i=0; i<numCourses; i++)
            adj.add(new ArrayList<>());
        
        //create adjacency list
        for(int i=0; i<pre.length; i++) {
            int p = pre[i][1];
            int q = pre[i][0];
            //add an directed edge from p --> q
            adj.get(p).add(q);
        }

        return topoSortDfs(numCourses);
    }
}