class Solution {
    public int minSwaps(int[] nums) {
        int onesCount = 0, n = nums.length;
        for(int ele : nums)
            if(ele == 1)
                onesCount++;
        int ans = n, zeroCount = 0;
        for(int i=0; i<n && i<onesCount; i++) {
            if(nums[i] == 0)
                zeroCount++;
        }
        ans = Math.min(ans, zeroCount);
        //System.out.println(onesCount+" -- "+zeroCount+" -- "+ans);
        for(int i=1; i<n; i++) {
            int j = (i+onesCount-1)%n;
            //System.out.println(i+" -- "+j+" -- "+ans);
            zeroCount = (nums[i-1] == 0) ? --zeroCount : zeroCount;
            zeroCount = (nums[j] == 0) ? ++zeroCount : zeroCount;
            ans = Math.min(ans, zeroCount);
        }
        return ans;
    }
}