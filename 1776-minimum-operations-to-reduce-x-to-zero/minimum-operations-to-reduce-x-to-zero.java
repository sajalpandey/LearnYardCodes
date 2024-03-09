class Solution {
    public int minOperations(int[] nums, int x) {
        int arr_sum = 0;
        for(int ele : nums)
            arr_sum += ele;
        int rem_sum = arr_sum - x;
        if(rem_sum == 0)
            return nums.length;
        
        int i = 0, j = 0, curr_sum = 0;
        int length = -1;
        while(j < nums.length) {
            curr_sum += nums[j];

            while(i < nums.length && curr_sum > rem_sum)
                curr_sum -= nums[i++];

            if(curr_sum == rem_sum) {
                length =  Math.max(length, j - i + 1);
            }
            j++;
        }

        return (length != -1 ? nums.length - length : -1);
    }
}