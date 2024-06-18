class Edge {
	int node;
	int weight;
	
	Edge(int node, int weight) {
		this.node = node;
		this.weight = weight;
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
    static ArrayList<ArrayList<Edge>> adj;
    static class comp implements Comparator<Node> {
		public int compare(Node a, Node b) {
			if(a.dist > b.dist)
				return 1;
			else if(a.dist == b.dist && a.node == b.node)
				return 0;
			else
				return -1;
		}
	}
    public static int bellmanFord(int src, int ds, int[][] edges, int n) {
        int m = edges.length;
		long[] d = new long[n+1];
		Arrays.fill(d, Long.MAX_VALUE);
		
		d[src] = 0;
		//Relax all the edges(u,v,weight) V-1 times
		for(int i=1; i<n; i++) {
			for(int j=0; j<m; j++) {
				for(int[] e : edges) {
					int u = e[0], v = e[1], w = e[2];
					if(d[u] != Long.MAX_VALUE && (d[u] + w) < d[v]) {
						d[v] = d[u] + w;
					}

                    // if((d[v] + w) < d[u])
                    //     d[u] = d[v] + w;
				}
			}
		}
		
		//Perform relation Nth time if any distance is changed that mean there is negative cycle
		// boolean flag = true;
		// for(int j=0; j<m; j++) {
		// 	for(int[] e : edges) {
		// 		int u = e[0], v = e[1], w = e[2];
		// 		if((d[u] + w) < d[v]) {
		// 			flag = false;
		// 		}
		// 	}
		// }
		
		// if(flag == false)
		// 	System.out.println(" Finding Shortest path is not possible as negative cycle exists");
		// else// return distance vector 
		// 	return d;
        int ans = 0;
        for(int i=0; i<d.length; i++) {
            if(d[i] <= ds)
                ans++;
        }
		return ans;
	}

    public static int dijkstra(int src, int n, int ds) {
		int[] d = new int[2*n+1];
		
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
        int ans = 0;
        
        for(int i=0; i<d.length; i++) {
            //System.out.print(d[i]+" ");
            if(d[i] <= ds)
                ans++;
        }
        //System.out.println("src= "+src+"- ans = "+ans);
		return ans;
	}
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[] cities = new int[n];
        int[][] e = new int[2*edges.length][3];
        int k = 0;
        adj = new ArrayList<>();
        for(int i = 0; i <= n; ++i)
            adj.add(new ArrayList<>());
        for(int i=0; i<edges.length; i++) {
            int u = (edges[i][0]);
            int v = (edges[i][1]);
            int wt = (edges[i][2]);

            adj.get(u).add(new Edge(v, wt));
            adj.get(v).add(new Edge(u, wt));

            e[k][0] = edges[i][0];
            e[k][1] = edges[i][1];
            e[k++][2] = edges[i][2];

            e[k][0] = edges[i][1];
            e[k][1] = edges[i][0];
            e[k++][2] = edges[i][2];
        }
        //BellMan Ford
        // for(int src=0; src<n; src++)
        //     cities[src] = bellmanFord(src, distanceThreshold, e, n);
        
        //Dijkastra
        for(int src=0; src<n; src++)
            cities[src] = dijkstra(src, n, distanceThreshold);

        int result = Integer.MAX_VALUE;
        int city = n-1;

        for(int src=0; src<n; src++) {
            //System.out.print(cities[src]+"   ");
            if(result >= cities[src]) {
                result = cities[src];
                city = src;
            }
        }
        return city;
    }
}