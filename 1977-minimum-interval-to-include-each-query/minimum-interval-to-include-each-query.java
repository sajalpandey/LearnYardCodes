class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        //First solution for each query search intervals and find answer
        //TC: m*n ==> n^2

        //Second sort both interval and queries and keep a min heap
        int[] Q = queries.clone();
        Arrays.sort(queries);
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));

        //we will keep distance and r in min heap
        PriorityQueue<int[]> minh = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0, n = intervals.length;
        for(int q : queries) {
            //now we will find how many intervals contain this q
            //added all those intervals in min heap
            while(i < n && intervals[i][0] <= q) {
                int left = intervals[i][0], right = intervals[i][1];
                int dist = right - left + 1;
                minh.add(new int[]{dist, right});
                i++;
            }

            while(!minh.isEmpty() && minh.peek()[1] < q)
                minh.poll();
            // System.out.println(q+" -- "+(minh.isEmpty() == true ? -1 : minh.peek()[0]));
            map.put(q, minh.isEmpty() == true ? -1 : minh.peek()[0]);
        }
        i = 0;
        int[] result = new int[queries.length];
        for(int q : Q) {
            // System.out.println(q+"-- "+map.get(q));
            result[i++] = map.get(q);
        }
        return result;
    }
}