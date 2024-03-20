class RecentCounter {
    Queue<Integer> q;
    public RecentCounter() {
        q = new LinkedList<>();
    }
    
    public int ping(int t) {
        // [1,100,3001,3002]
        // i=3002
        // range[3002-3000,3002] = {2,3002}
        // travers in array and find which numbers are lying in thr range
        q.add(t);
        while(q.peek() < (t-3000))
            q.remove();
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */