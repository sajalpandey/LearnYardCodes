class Solution {
    public static int findMinIndex(int[] array) {
        if (array.length == 0) {
            return -1;
        }
        int minIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        while(k-- > 0) {
            int minIdx = findMinIndex(nums);
            nums[minIdx] *= multiplier;
        }
        return nums;
    }
}