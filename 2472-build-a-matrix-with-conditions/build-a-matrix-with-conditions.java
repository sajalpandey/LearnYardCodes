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
        for(int i=1; i<=n; i++) {
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
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        adj = new ArrayList<>();
        vis = new int[k+1];
        for(int i=0; i<=k; i++)
            adj.add(new ArrayList<>());
        
        //create adjacency list
        for(int i=0; i<rowConditions.length; i++) {
            int p = rowConditions[i][1];
            int q = rowConditions[i][0];
            //add an directed edge from p --> q
            adj.get(q).add(p);
        }
        int[] left = topoSortDfs(k);
        Arrays.fill(vis, 0);
        adj.clear();
        for(int i=0; i<=k; i++)
            adj.add(new ArrayList<>());
        
        //create adjacency list
        for(int i=0; i<colConditions.length; i++) {
            int p = colConditions[i][1];
            int q = colConditions[i][0];
            //add an directed edge from p --> q
            adj.get(q).add(p);
        }
        int[] right = topoSortDfs(k);
        int[][] result = new int[k][k];
        if(left.length == 0 || right.length == 0)
            return new int[][] {};
        /**
        Find row ordering of elements using Topo sort
        Find Col ordering of elements using Topo sort
        Now from row ordering we know where to place that ele in row , but in which col of that row
        To find col we will store col index of each ele from col ordering
        now while placing row ordering will give row , and col Index will give column in that
        particular ROW
         */
        HashMap<Integer, Integer> colIndex = new HashMap<>();
        for(int i=0; i<right.length; i++)
            colIndex.put(right[i], i);
        
        for(int i=0; i<k; i++) {
            for(int j=0; j<k; j++) {
                result[i][colIndex.get(left[i])] = left[i];
            }
        }
        return result;
    }
}