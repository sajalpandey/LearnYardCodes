class MedianFinder {
    //Right Half will be stored in minHeap
    PriorityQueue<Integer> minH = new PriorityQueue<>();
    //Left Half will be stored in maxHeap
    PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        int p = minH.size();
        int q = maxH.size();
        if(q > p) {
            // We need to insert in minHeap
            maxH.add(num);
            minH.add(maxH.poll());
        } else {
            // We need to insert in maxHeap
            minH.add(num);
            maxH.add(minH.poll());
        }
    }
    
    public double findMedian() {
        int p = minH.size();
        int q = maxH.size();
        if(q > p) {
            return maxH.peek();
        } else {
            int a = maxH.peek();
            int b = minH.peek();
            return ((double)(a+b)/2);
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */