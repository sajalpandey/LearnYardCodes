class Solution {
    static List<List<Integer> > adj;
    int nums;
    public void dfs(int curr, int par, List<Boolean> hasApple) {
        for (int child : adj.get(curr)) {
            if (child == par)
                continue;
            dfs(child, curr, hasApple);
            if(hasApple.get(child)) {
                hasApple.set(curr, true);
                nums += 2; 
            }   
        }
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        adj = new ArrayList<>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        
        for(int i=0; i<n-1; i++) {
            int p = edges[i][0];
            int q = edges[i][1];

            adj.get(p).add(q);
            adj.get(q).add(p);
        }
        //nums = new int[n];
        dfs(0, -1, hasApple);

        return nums;
    }
}