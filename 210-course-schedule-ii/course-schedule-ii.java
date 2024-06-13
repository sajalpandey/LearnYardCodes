class Solution {
    List<List<Integer>> adj;
    int[] vis;

    public boolean dfs(int curr, Stack<Integer> st) {
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
    public int[] topoSortDfs(int n) {
        Stack<Integer> st = new Stack();
        for(int i=0; i<n; i++) {
            if(vis[i] == 0) {
                boolean possible = dfs(i, st);
                if(!possible)
                    return new int[] {};
            }
        }
        int[] ans = new int[st.size()];
        int k = 0;
        while(!st.isEmpty()) {
            ans[k++] = st.peek();
            st.pop();
        }

        return ans;
    }
    public int[] findOrder(int numCourses, int[][] pre) {
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