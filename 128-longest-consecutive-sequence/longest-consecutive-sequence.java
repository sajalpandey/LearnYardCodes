class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int ele : nums)
            set.add(ele);
        int maxLen = 0;
        for(int i=0; i<nums.length; i++) {
            if(!set.contains(nums[i] - 1)) {
                int count = 1;
                int ele = nums[i] + 1;
                while(set.contains(ele)) {
                    count++;
                    ele++;
                }
                maxLen = Math.max(maxLen, count);
            }
        }
        return maxLen;
    }
}