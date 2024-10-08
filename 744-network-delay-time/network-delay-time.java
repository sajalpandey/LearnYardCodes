class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //create adj list
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++)
            adj.add(new ArrayList<>());
        
        for(int[] time : times)
            adj.get(time[0]).add(new int[]{time[1], time[2]});
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> (x[1] -y[1]));
        int[] dist = new int[n+1];
        Arrays.fill(dist, (int)1e9);
        dist[k] = 0;

        pq.add(new int[] {k,0});

        while(!pq.isEmpty()) {
            int[] pair = pq.poll();
            int node = pair[0];
            int time = pair[1];

            for(int[] nb : adj.get(node)) {
                int t = nb[1];
                int dst = nb[0];

                if(dist[dst] > (time + t)) {
                    dist[dst] = time + t;
                    pq.add(new int[] {dst, dist[dst]});
                }
            }
        }
        int minTime = -1;
        for(int i=1; i<=n; i++) {
            if(dist[i] == (int)1e9)
                return -1;
            minTime = Math.max(minTime, dist[i]);
        }

        return minTime;
    }
}