class Solution {
    public int binarySearch(int [] arr, int  target, int lo, int hi) {
        while(lo <= hi) {
            int mid = (lo + hi) / 2;

            if(arr[mid] == target)
                return mid;
            else if(arr[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }
    public int[] twoSum(int[] numbers, int target) {
        int result[] = new int[2];
        int n = numbers.length;
        for(int i=0; i<n; ++i) {
            int rem = target - numbers[i];
            int index = binarySearch(numbers,rem,i+1,n-1);
            if (index != -1) {
                result[0] = i + 1;
                result[1] = index + 1;
                return result;
            }
        }
        return result;
    }
}