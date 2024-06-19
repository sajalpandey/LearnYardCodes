class Solution {
    final int inf = (int)1e9;
    public int[][] floydWarshell(int[][] edges, int n) {
        int[][] d = new int[n][n]; // 0 to n-1
		for(int[] row : d)
			Arrays.fill(row, inf);

		// Initialise the d array properly
		for(int i = 0; i < n; ++i)
			d[i][i] = 0;
		
		for(int[] e : edges) { // {i, j, w}
			d[e[0]][e[1]] = e[2];
			d[e[1]][e[0]] = e[2];
		}

		// Get done with the phases
		for(int k = 0; k < n; ++k) // kth phase
            for(int i = 0; i < n; ++i)
                for(int j = 0; j < n; ++j)
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);

		return d;
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        //Solve using floyd warshell

        int[][] d = floydWarshell(edges, n);
        
        int ans = -1, minCount = Integer.MAX_VALUE;
		for(int i = 0; i < n; ++i) {
			int curCount = 0;
			for(int j = 0; j < n; ++j)
				if(d[i][j] <= distanceThreshold)
					curCount += 1;
            System.out.println(curCount);
			if(curCount <= minCount) {
				minCount = curCount;
				ans = i;
			}
		}

		return ans;

    }
}