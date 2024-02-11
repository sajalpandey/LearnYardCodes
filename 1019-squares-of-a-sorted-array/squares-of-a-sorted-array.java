class Solution {
    public int[] sortedSquares(int[] nums) {
        int arr[] = new int[100000];
        for(int i=0; i<nums.length; i++)
            arr[Math.abs(nums[i])]++;
        
        int [] result = new int[nums.length];
        int k=0;
        for(int i=0; i<100000; i++)
            if(arr[i]!=0) {
                while(arr[i]-- > 0)
                    result[k++] = i*i;
            }

        return result;
    }
}