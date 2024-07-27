class Solution {
    final long inf = (int)1e9;
    public long[][] floydWarshell(List<int[]> edges, int n) {
        long[][] d = new long[n][n]; // 0 to n-1
		for(long[] row : d)
			Arrays.fill(row, inf);

		// Initialise the d array properly
		for(int i = 0; i < n; ++i)
			d[i][i] = 0;
		
		for(int[] e : edges) { // {i, j, w}
			d[e[0]][e[1]] = Math.min(d[e[0]][e[1]], e[2]);
			//d[e[0]][e[1]] = e[2];
		}

		// Get done with the phases
		for(int k = 0; k < n; ++k) // kth phase
            for(int i = 0; i < n; ++i)
                for(int j = 0; j < n; ++j)
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);

        // for(int i = 0; i < n; ++i)
        //     for(int j = 0; j < n; ++j)
        //         if(d[i][j] == inf)
        //             d[i][j] = -1;
		return d;
    }
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        //Solve using floyd warshell
        List<int[]> edges = new ArrayList<>();
        for(int i=0; i<original.length; i++) {
            edges.add(new int[]{original[i]-'a',changed[i]-'a',cost[i]});
        }

        long[][] d = floydWarshell(edges, 26);
        
        long ans = 0;
        for(int i=0; i<source.length(); i++) {
            int j = target.charAt(i) - 'a';
            int p = source.charAt(i) - 'a';
            if(d[p][j] == inf)
                return -1L;
            //System.out.println(source.charAt(i)+" --> "+target.charAt(i)+" = "+d[p][j]);
            ans += d[p][j];
        }
        return ans;
    }
}