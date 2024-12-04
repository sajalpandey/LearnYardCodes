class Solution {
    public int helper(int[] nums, int target, int i, int sum) {
        if(i >= nums.length)
            return target == sum ? 1 : 0;
        int op1 = 0, op2 = 0;
        
        op1 = helper(nums, target, i+1, sum-nums[i]);
        op2 = helper(nums, target, i+1, sum+nums[i]);
        
        return op1+op2;
    }
    HashMap<String, Integer> map ;
    public int helperTopDown(int[] nums, int target, int i, int sum) {
        if(i >= nums.length)
            return target == sum ? 1 : 0;

        String key = i+","+sum;
        if(map.containsKey(key)) {
            return map.get(key);
        }
        
        int op1 = 0, op2 = 0;
        
        op1 = helperTopDown(nums, target, i+1, sum-nums[i]);
        op2 = helperTopDown(nums, target, i+1, sum+nums[i]);
        map.put(key, op1+op2);
        return op1+op2;
    }
    public int findTargetSumWays(int[] nums, int target) {
        // return helper(nums, target, 0, 0);
        int n = nums.length;
        map = new HashMap<>();
        
        return helperTopDown(nums, target, 0, 0);
    }
}