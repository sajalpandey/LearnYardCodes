class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int arr[] = new int[n];
        for(int i=0; i<n-1; i++) {
            if(nums[i] < nums[i+1])
                arr[i] = 1;
            else if(nums[i] > nums[i+1])
                arr[i] = -1;
        } 
        int result = 0;
        for(int i=0; i<n-pattern.length; i++) {
                int end = i + pattern.length;
                int k = i;
                int p = 0;
                while(k < end && arr[k]==pattern[p]) {
                    k++;
                    p++;
                }
                result = k>=end ? ++result : result;
        }
        return result;
    }
}