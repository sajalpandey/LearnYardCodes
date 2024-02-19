class Solution {
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
    public static void reverse(int []nums, int i, int j) {
        while(i < j) {
            int temp = nums[j];
            nums[j--] = nums[i];
            nums[i++] = temp;
        }
    }
    public void nextPermutation(int[] nums) {
        int pivot = -1, n = nums.length;
        for(int i=n-2; i>=0; i--) {
            if(nums[i] < nums[i+1]) {
                pivot = i;
                for(int j=n-1; j>pivot; j--) {
                    if(nums[j] > nums[pivot]) {
                        swap(nums,j,pivot);
                        break;
                    }
                }
                break;
            }
        }

        reverse(nums,pivot+1,n-1);
    }
}