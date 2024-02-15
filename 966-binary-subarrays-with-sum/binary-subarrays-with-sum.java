class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> prefix = new HashMap<>();
        int sum = 0, result = 0;
        prefix.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum >= goal){
                int rem = sum - goal;
                if (prefix.containsKey(rem)) {
                    result += prefix.get(rem);
                }
            }
            prefix.put(sum, prefix.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}