class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //First approach is check every window of size k TC(n*k)
        //Optimized is using deque
        Deque<Integer> dq = new LinkedList<>();
        int n = nums.length;
        int[] result = new int[n-k+1];
        int p = 0, i = 0;
        while(i < n) {
            //Logic how to keep in Dq
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.removeLast();

            //Logic when to remove from dq
            while(!dq.isEmpty() && dq.peekFirst() <= (i-k))
                dq.removeFirst();

            dq.addLast(i);
            //update result
            if(i >= k-1)
                result[p++] = nums[dq.peekFirst()];
            i++;
        }

        return result;
    }
}