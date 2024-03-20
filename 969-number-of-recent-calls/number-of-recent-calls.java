class RecentCounter {
    ArrayList<Integer> arr;
    public RecentCounter() {
        arr = new ArrayList<>();
    }
    
    public int ping(int t) {
        // [1,100,3001,3002]
        // i=3002
        // range[3002-3000,3002] = {2,3002}
        // travers in array and find which numbers are lying in thr range
        arr.add(t);
        int count = 0;
        int l = t - 3000;
        int h = t;
        for(int ele : arr) {
            if(ele >= l && ele <= h)
                count++;
        }
        return count;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */