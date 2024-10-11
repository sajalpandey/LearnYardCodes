class Pair {
    double prob;
    int node;
    Pair(double p, int n) {
        this.prob = p;
        this.node = n;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edge, double[] succProb, int start_node, int end_node) {
        //Make a graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) 
            adj.add(new ArrayList<>());
        
        for(int i=0; i<edge.length; i++) {
            adj.get(edge[i][0]).add(new Pair(succProb[i], edge[i][1]));
            adj.get(edge[i][1]).add(new Pair(succProb[i], edge[i][0]));
        }

        //max Heap
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Double.compare(y.prob, x.prob));

        //for src node src to src probability will be 1
        double[] dist = new double[n];
        Arrays.fill(dist, 0);

        dist[start_node] = 1.0;
        pq.add(new Pair(1.0, start_node));

        while(!pq.isEmpty()) {

            Pair pair = pq.poll();
            int node = pair.node;
            double probability = pair.prob;

            for(Pair neighbour : adj.get(node)) {
                int nb = neighbour.node;
                double p = neighbour.prob;

                if(dist[nb] < (probability * p)) {
                    dist[nb] = (probability * p);
                    pq.add(new Pair(dist[nb], nb));
                }
            }
        }

        return dist[end_node];
    }
}