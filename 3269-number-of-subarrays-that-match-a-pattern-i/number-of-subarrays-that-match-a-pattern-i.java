class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int arr[] = new int[n];
        for(int i=0; i<n-1; i++) {
            if(nums[i] < nums[i+1])
                arr[i] = 1;
            else if(nums[i] > nums[i+1])
                arr[i] = -1;
            //System.out.print(arr[i]+" ");
        } 
        System.out.println();
        int result = 0;
        for(int i=0; i<n-pattern.length; i++) {
            if(arr[i] == pattern[0]) {
                int end = i + pattern.length;
                int k = i;
                int p = 0;
                while(k < end ) {
                    if(arr[k]!=pattern[p])
                        break;
                    k++;
                    p++;
                }
                if(k >= end)
                    result++;
            }
        }
        return result;
        //return (result > pattern.length ? pattern.length : result);
    }
}