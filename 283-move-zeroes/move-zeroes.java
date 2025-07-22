class Solution {
    public void moveZeroes(int[] arr) {
        int i = 0, j = 0;
        while(j < arr.length) {
            if(arr[j] != 0) {
                arr[i++] = arr[j++];
            } else {
                j++;
            }
        }
        while(i < arr.length) {
            arr[i++] = 0;
        }
    }
}