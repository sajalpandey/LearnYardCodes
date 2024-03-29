class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0, maxSum = 0;
        int i = 0, j = 0;
        while(j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            sum += nums[j];
            while(i < j && map.get(nums[j]) > 1){
                int freq = map.get(nums[i]);
                map.put(nums[i], freq - 1);
                sum -= nums[i];
                i++;
            }
            j++;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}