class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i;
        for(i=1; i<heights.length; i++) {
            if(heights[i] <= heights[i-1])
                continue;
            else {
                int diff = heights[i] - heights[i-1];
                pq.add(diff);
                if(pq.size() > ladders) {
                    bricks -= pq.poll();
                }
                if(bricks < 0)
                    break;
            }
        }
        return i-1;
    }
}