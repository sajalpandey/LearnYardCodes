
class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        
        // Create adjacency list
        for (int[] road : roads) {
            adj.get(road[0]).add(new int[]{road[1], road[2]});
            adj.get(road[1]).add(new int[]{road[0], road[2]});
        }

        // Create a priority queue
        PriorityQueue<long[]> pq = new PriorityQueue<>((x, y) -> Long.compare(x[0], y[0]));
        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1; // From src to src, there is only 1 way
        // {dist, src}
        pq.add(new long[]{0, 0});
        int mod = (int)1e9 + 7;

        while (!pq.isEmpty()) {
            long[] row = pq.poll();
            int node = (int)row[1];
            long d = row[0];
            
            // Iterate through every neighbor
            for (int[] nbh : adj.get(node)) {
                int nb = nbh[0];
                long distance = nbh[1];
                long cost = d + distance;
                
                if (dist[nb] > cost) {
                    dist[nb] = cost;
                    ways[nb] = ways[node];
                    pq.add(new long[]{dist[nb], nb});
                } else if (dist[nb] == cost) {
                    ways[nb] = (ways[nb] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1] ; // Ensure non-negative paths
    }
}
