class Tuple {
    int stop;
    int node;
    int dest;
    Tuple(int f, int t, int p) {
        this.stop = f;
        this.node = t;
        this.dest = p;
    }
}

class Pair {
    int to;
    int price;
    Pair(int t, int p) {
        this.to = t;
        this.price = p;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        
        int[] d = new int[n];
        for(int i = 0;i<n;i++) {
            d[i] = (int)(1e9); 
        }
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        for(int[] row : flights) 
            adj.get(row[0]).add(new Pair(row[1], row[2]));
        
        Queue<Tuple> q = new LinkedList<>();

        q.add(new Tuple(0, src, 0));
        d[src] = 0;

        while(!q.isEmpty()) {
            Tuple t = q.peek();
            q.remove();
            int stops = t.stop;
            int node = t.node;
            int dest = t.dest;
            //don't traverse on its neighbour 
            if(stops > k)
                continue;
            for(Pair p : adj.get(node)) {
                if(dest + p.price < d[p.to] && stops <= k) {
                    d[p.to] = dest + p.price;
                    q.add(new Tuple(stops+1, p.to, d[p.to]));
                }
            }
        }
        if(d[dst] != (int)1e9)
            return d[dst];
        return -1;
    }
}