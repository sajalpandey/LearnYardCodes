class Solution {
    public int pivotIndex(int[] nums) {
        int result = -1;
        int prefix[] =  new int[nums.length];
        prefix[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            prefix[i] = nums[i] + prefix[i-1];
        }
        int sum = 0;
        for(int i=nums.length-1; i>=0; i--) {
            //System.out.println("sum = "+sum+" prefix[i] = "+prefix[i]);
            if(sum==(prefix[i]-nums[i]))
                result = i;
            sum += nums[i];
        }
        return result;
    }
}