class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int prefix[] = new int[1001];
        for(int[] row : trips) {
            prefix[row[1]] -= row[0];
            prefix[row[2]] += row[0];
        }

        for(int i=1; i<=1000; i++) {
            prefix[i] = prefix[i] + prefix[i-1];
        }
        // for(int i=0; i<=10; i++)
        //     System.out.print(prefix[i]+" ");
        for(int i=0; i<=1000; i++)
            if(prefix[i] + capacity < 0)
                return false;
        return true;
    }
}