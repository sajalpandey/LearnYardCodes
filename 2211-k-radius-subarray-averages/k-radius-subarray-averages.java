class Solution {
    public int[] getAverages(int[] nums, int k) {
        if (k == 0)
            return nums;
        
        int ws = 2*k + 1;
        int i = 0 ; long sum = 0;
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        if (2 * k + 1 > nums.length) return result;
        while(i < ws && i < nums.length) {
            sum += nums[i++];
        }
        result[k] = (int)(sum / (2*k+1));
        i = k+1;
        while(i < nums.length - k) {
            sum -= nums[i-k-1];
            sum += nums[i+k];
            result[i] = (int)(sum / (2*k+1));
            i++;
        }
        return result;
    }
}