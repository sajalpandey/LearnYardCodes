class Solution {
    public boolean isPossible(int[] nums, int mid, int k) {
        int count = 0;
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            if((sum + nums[i]) <= mid) {
                sum += nums[i];
            } else {
                sum = 0;
                sum += nums[i];
                count++;
            }
        }
        if(sum!=0)
            count++;
        //System.out.println("mid = "+mid+" -- k = "+k+" --count = "+count);
        return (count <= k);
    }
    public int splitArray(int[] nums, int k) {
        int lo = nums[0], hi = 0;
        for(int ele : nums) {
            lo = Math.max(lo, ele);
            hi += ele;
        }
        if(k == nums.length)
            return lo;
        int result = 0;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(isPossible(nums, mid, k)) {
                result = mid;
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return result;
    }
}