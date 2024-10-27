class Solution {
    public int[][] kClosest(int[][] points, int k) {
        /**
        distance x1(0,0), x1(x,y)
        sqrt(x^2 + y^2)
        [0, 1,        2]
        (x, y, distfromOrigin)
        */
        
        //Max heap based on dist from origin
        PriorityQueue<int[]> maxH = new PriorityQueue<>((a,b) -> (b[2] - a[2]));

        for(int[] row : points) {
            int x = row[0], y = row[1];
            int dist = x*x + y*y;

            maxH.add(new int[] {x, y, dist});
            if(maxH.size() > k)
                maxH.poll();
        }

        int size = maxH.size();
        int[][] result = new int[size][2];
        int i = 0;
        while(maxH.size() > 0) {
            result[i][0] = maxH.peek()[0];
            result[i++][1] = maxH.peek()[1];     
            maxH.poll();
        }

        return result;
    }
}