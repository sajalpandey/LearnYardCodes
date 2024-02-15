class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        /*
         * [1,0,1,0,1], goal = 2
         * 0,1,2,3,4
         * prefix [1,1,2,2,3] 3 - goal = 1
         * 4th index = total sum = 3
         * till 1st index sum = 1 = 2
         * Algo
         * 0. We will create a prefix sum array
         * 1. we will traverse the given array
         * 2. if the sum till that index is equal to our goal , we will increment our
         * result
         * 3. else if sum till that index is < goal --> keep traversing
         * 4. else if sum till that index is > goal
         * a. then we will find a subarray whose sum is equal to prefix sum (i) - goal
         */

        HashMap<Integer, Integer> prefix = new HashMap<>();
        int sum = 0, result = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == goal) {
                result++;
            }
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