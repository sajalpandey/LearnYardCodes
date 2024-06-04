class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele : nums)
            pq.add(ele);
        while(k-- > 0) {
            int ele = pq.poll();
            ele++;
            pq.add(ele);
        }

        long ans = 1;
        int mod = 1000000000 + 7;
        while(!pq.isEmpty()) {
            ans = (ans * pq.poll()) % mod;
        }
        return (int)ans;
    }
}