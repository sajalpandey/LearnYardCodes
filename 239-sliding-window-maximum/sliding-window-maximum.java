class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int size = nums.length - k + 1;
        int[] result = new int[size];
        Deque<Integer> dq = new LinkedList<>();
        //idea here is to keep indexes in deque, ele which is max shoudl be in front 
        //with in window index only
        int p = 0;
        for(int i=0; i<nums.length; i++) {
            int ele = nums[i];
            while(!dq.isEmpty() && nums[dq.peekLast()] < ele) {
                dq.removeLast();
            }
            if(!dq.isEmpty() && dq.peekFirst() <= i-k) {
                dq.removeFirst();
            }
            dq.addLast(i);
            if(i >= k - 1) {
                result[p++] = nums[dq.peekFirst()];
            }
        }
        return result;
    }
}