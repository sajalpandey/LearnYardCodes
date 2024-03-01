class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        int [] freq = new int[101];
        for(int ele : nums){
            freq[ele]++;
            if(freq[ele] > 2)
                return false;
        }
        return true;
    }
}