class Solution {
    public void duplicateZeros(int[] arr) {
        int i=0,  j=0, n = arr.length;
        i=n-1;
        while(i >= 0) {
            int count = 0;
            for(j=0; j<i; j++)
                if(arr[j] == 0)
                    count++;
            if(count+i < n)
                arr[count+i] = arr[i];
            i--;
        }
        for(i=0; i+1<n; i++)
            if(arr[i] == 0)
                arr[1+i++] = 0;
    }
}