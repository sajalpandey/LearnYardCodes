class Pair {
    int a;
    int b;
    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
class Solution {
    public long maximumImportance(int n, int[][] roads) {
        List<Pair> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] indegree = new int[n];
        for(int[] row : roads) {
            indegree[row[0]]++;
            indegree[row[1]]++;
        }
        for(int i=0; i<n; i++) {
            list.add(new Pair(i, indegree[i]));
        }
        Collections.sort(list, (l1, l2) -> (l1.b - l2.b));
        long ans = 0;
        for(int i=0; i<n; i++) {
            int rank = i+1;
            int node = list.get(i).a;
            map.put(node, rank);
        }

        for(int i=0; i<roads.length; i++) {
            ans += map.get(roads[i][0]);
            ans += map.get(roads[i][1]);
        }

        return ans;
    }
}