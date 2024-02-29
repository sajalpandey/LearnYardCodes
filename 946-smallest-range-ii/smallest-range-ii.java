class Solution {
    public int smallestRangeII(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int mx = arr[n-1] - k;
        int mn = arr[0] + k;
        int result = arr[n-1] - arr[0];
        for(int i=0; i<n-1; i++) {
            mn = Math.min(arr[0] + k, arr[i+1] - k);
            mx = Math.max(arr[n-1] - k, arr[i] + k);

            result = Math.min(result,(mx-mn));
        }
        return result;
    }
}