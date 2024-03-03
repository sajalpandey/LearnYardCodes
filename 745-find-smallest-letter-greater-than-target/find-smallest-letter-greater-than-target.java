class Solution {
    public char nextGreatestLetter(char[] arr, char target) {
        char result = arr[0];
        int n = arr.length;
        int lo = 0, hi = n-1;

        while(lo <= hi) {
            int mid = (lo +  hi) / 2;
            
            if(arr[mid] <= target)
                lo = mid + 1;
            else {
                result = arr[mid];
                hi = mid - 1;
            }
        }
        return result;
    }
}