class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int result[][] = new int [n/3][3];
        Arrays.sort(nums);
        int j = 0,i=0;
        for(i=2; i<n; i=i+3) {
            int a = nums[i-2];
            int b = nums[i-1];
            int c = nums[i];
            if((b-a) > k || (c-b) > k || (c-a) > k)
                return new int[0][];
            else {
                result[i/3][0] = a;
                result[i/3][1] = b;
                result[i/3][2] = c;
            }
        }
        return result;
    }
}