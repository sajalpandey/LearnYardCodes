class Solution {
    public int alternatingSubarray(int[] nums) {
        int mx_len = -1;
        //Check from each element
        //we need to identify how many increasing decreasing numbers in diff = 1
        for(int i=0; i<nums.length; i++) {
            int diff = 1;
            for(int j=i+1; j<nums.length; j++) {
                if(nums[j]-nums[j-1] == diff) {
                    mx_len = Math.max(mx_len,(j-i+1));
                    diff = -diff;
                } else
                    break;
            }
        }
        return (mx_len);
    }
}