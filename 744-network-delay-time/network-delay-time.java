class Edge {
    int node;
    int weight;
    Edge(int n, int w) {
        node = n;
        weight = w;
    }
}

class Node {
	int node;
	int dist;
	
	Node(int node, int dist) {
		this.node = node;
		this.dist = dist;
	}
}

class Solution {
    List<List<Edge> > adj = new ArrayList<>();
    class comp implements Comparator<Node> {
		public int compare(Node a, Node b) {
			if(a.dist > b.dist)
				return 1;
			else if(a.dist == b.dist && a.node == b.node)
				return 0;
			else
				return -1;
		}
	}
    public  int[] dijkstra(int src, int n) {
		int[] d = new int[n+1];
		
		//initialize dist with inf for every node from source
		Arrays.fill(d, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>(new comp());
		
		//Insert src node with distance from src as 0 in pq
		pq.add(new Node(src, 0));
		d[src] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			int curr = node.node;
			int distance = node.dist;
			
			if(d[curr] != distance)
                continue;
			for(Edge e : adj.get(curr)) {
				int nb = e.node;
				int w = e.weight;
				
				if(d[nb] > d[curr] + w) {
					d[nb] = d[curr] + w;
					pq.add(new Node(nb, d[nb]));
				}
			}
		}

        for(int i = 1; i <= n; ++i)
            if(d[i] == Integer.MAX_VALUE)
                d[i] = -1;
            
        return d;
	}
    public int networkDelayTime(int[][] times, int n, int k) {
        
        for(int i = 0; i <= n; ++i)
            adj.add(new ArrayList<>());
        
        for(int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Edge(v, w));
        }

        int ans = -1;
        int[] d = dijkstra(k, n);

        for(int i=1; i<d.length; i++) {
            if(d[i] == -1)
                return -1;
            ans = Math.max(ans, d[i]);
        }

        return ans;
    }
}