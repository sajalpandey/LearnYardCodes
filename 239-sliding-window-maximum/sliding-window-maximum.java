class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        Deque<Integer> dq = new LinkedList<>();
        int result[] = new int[n-k+1];
        int p=0;
        for(int i=0; i<n; ++i) {
            
            while(dq.size() > 0 && arr[dq.peekLast()] <= arr[i])
                dq.removeLast();
            
            dq.addLast(i);
            
            if(dq.peekFirst() <= i-k) {
                dq.removeFirst();
            }
            
            if(i >= k-1)
                result[p++] = arr[dq.peekFirst()];
        }
        return result;
    }
}