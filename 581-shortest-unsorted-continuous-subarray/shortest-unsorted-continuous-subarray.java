class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int sorted[] = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int start = -1, end=-2;
        for(int i=0; i<nums.length; i++) {
            if(sorted[i]!=nums[i]) {
                if(start==-1)
                    start = i;
                else
                    end = i;
            }   
        }
        return (end-start+1);
    }
}