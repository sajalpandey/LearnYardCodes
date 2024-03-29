class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0, maxSum = 0;
        int i = 0, j = 0;
        while(j < nums.length) {
            if(!set.contains(nums[j])) {
                sum += nums[j];
                set.add(nums[j++]);
                maxSum = Math.max(maxSum, sum);
            } else {
                while(i < j && set.contains(nums[j])) {
                    sum -= nums[i];
                    set.remove(nums[i++]);
                }
            }
        }
        return maxSum;
    }
}