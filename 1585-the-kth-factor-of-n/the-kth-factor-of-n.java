class Solution {
    public int kthFactor(int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1; i*i<=n; i++) {
            if(n%i==0) {
                int fact = n/i;
                if(fact != i) {
                    pq.add(fact);
                }
                pq.add(i);
            }
        }

        if(k > pq.size())
            return -1;
        k--;
        while(k-- > 0) {
            pq.poll();
        }
        return pq.peek();
    }
}