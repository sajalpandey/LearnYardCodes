class Solution {
    public static int[] merge(int[] left, int [] right) {
        int n = left.length + right.length;
        int [] result = new int[n];
        int i=0,j=0,k=0;
        while(i<left.length && j<right.length) {
            if(left[i] <= right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }
        while(i<left.length)
            result[k++] = left[i++];
        while(j<right.length)
            result[k++] = right[j++];
        return result;

    }
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        if(n==1)
            return nums;
        int [] left = Arrays.copyOfRange(nums,0,n/2);
        int [] right = Arrays.copyOfRange(nums,n/2,n);

        left = sortArray(left);
        right = sortArray(right);
        return merge(left,right);
    }
}