class Solution {
    static int count = 0;
    public void merge(int[] arr,int [] left,int right[]) {
        int i=0,j=0,k=0;
        int n1 = left.length;
        int n2 = right.length;
        // Merge elements from left and right back into the original array
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy the remaining elements of left[], if any
        while (i < n1) {
            arr[k++] = left[i++];
        }

        // Copy the remaining elements of right[], if any
        while (j < n2) {
            arr[k++] = right[j++];
        }
        i=0;j=0;
        while (i < n1 && j < n2) {
            long a = left[i];
            long b = right[j];
            //System.out.println(a+" -- "+b);
            if(a > 2 * b) {
                count += n1 - i;
                j++;
            } else
                i++;
        }
        
    }
    public void mergesort(int [] nums) {
        int n = nums.length;
        if(n<=1)
            return;
        int left [] = Arrays.copyOfRange(nums,0,n/2);
        int right [] = Arrays.copyOfRange(nums,n/2,n);
        mergesort(left);
        mergesort(right);
        merge(nums,left,right);
    }
    public int reversePairs(int[] nums) {
        count = 0;
        mergesort(nums);
        return count;
    }
}