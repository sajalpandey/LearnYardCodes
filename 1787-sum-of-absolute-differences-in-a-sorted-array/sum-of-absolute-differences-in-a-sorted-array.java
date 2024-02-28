class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int totalsum = 0;
        int [] result = new int[nums.length];
        int n = nums.length;
        for(int ele : nums)
            totalsum += ele;
        int leftsum = 0,rightsum = 0;
        for(int i=0; i<n; i++) {
            int leftans = (nums[i] * i - leftsum);
            leftsum += nums[i];
            rightsum = totalsum - leftsum;

            int rightans = (rightsum - nums[i]*(n-1-i));

            result[i] = (leftans + rightans);
        }
        return result;
    }
}