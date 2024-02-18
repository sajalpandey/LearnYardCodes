class Solution {
    public static int kadanesOne(int [] arr) {
        int curr_sum = arr[0],maxsofar=arr[0];
        for(int i=1; i<arr.length; i++) {
            curr_sum = Math.max(arr[i]+curr_sum,arr[i]);
            maxsofar = Math.max(curr_sum,maxsofar);
        }
        return maxsofar;
    }
    public static int kadanesOfTwo(int [] arr) {
        int [] newarr = new int [arr.length * 2];
        for(int i=0; i<arr.length; i++) {
            newarr[i] = arr[i];
            newarr[i+arr.length] = arr[i];
        }
        return kadanesOne(newarr);
    }
    public static long sumOfArray(int [] arr) {
        long sum = 0;
        for(int ele : arr)
            sum += ele;
        return sum;
    }
    public int kConcatenationMaxSum(int[] arr, int k) {
        boolean pos = false, neg = false;
        long modValue = 1000000007;
        long sum = sumOfArray(arr);
        long result;
        if(k==1)
            result = kadanesOne(arr);
        else if(sum < 0)
            result = kadanesOfTwo(arr);
        else {
            result = kadanesOfTwo(arr) + sum * (k-2);
        }
        
        if(result < 0)
            return 0;
        else
            return (int)(result % modValue);
    }
}