class Solution {
    public boolean isPossibleDivide(int[] hand, int groupSize) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele : hand)
            pq.add(ele);
        while(!pq.isEmpty()) {
            int ele = pq.poll();
            
            for(int i=1; i<groupSize; i++) {
                if(!pq.remove(ele+1))
                    return false;
                ele++;
            }
        }
        return true;
    }
}