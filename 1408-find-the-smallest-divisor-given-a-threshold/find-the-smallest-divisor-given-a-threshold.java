class Solution {
    public int findSum(int[] nums, int mid) {
        int sum = 0;
        for(int ele : nums) {
            if(ele  >= mid)
                sum += (ele/mid);
            if(ele%mid!=0)
                sum++;
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1, hi = Integer.MIN_VALUE;
        for(int ele : nums)
            hi = Math.max(ele, hi);
        
        int result = 0;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            int totalSum = findSum(nums, mid);
            if(totalSum > threshold) {
                lo = mid + 1;
            }
            else {
                result = mid;
                hi = mid -1;
            }
        }
        return result;
    }
}