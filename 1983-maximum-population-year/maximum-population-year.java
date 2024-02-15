class Solution {
    public int maximumPopulation(int[][] logs) {
        int prefix[] = new int[3000];
        for(int i=0; i<logs.length; i++) {
            prefix[logs[i][0]]++;
            prefix[logs[i][1]]--;
        }
        int mx_year=0, sum=0;
        for(int i=1949; i<2055; i++) {
            prefix[i] += prefix[i-1];
            if(prefix[i] > sum) {
                sum = prefix[i];
                mx_year = i;
            }
        }
        return mx_year;
    }
}