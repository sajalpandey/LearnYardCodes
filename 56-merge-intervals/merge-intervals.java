class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
        int i = 0, j = 1;
        while(j < n) {
            //Check if points i & j can be merged
            if(intervals[j][0] <= intervals[i][1]) {
                intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
            } else {
                i++;
                intervals[i][0] = intervals[j][0];
                intervals[i][1] = intervals[j][1];
            }
            j++;
        }
        int [][]result = new int[i+1][2];
        for(int k = 0; k<=i; k++) {
            result[k][0] = intervals[k][0];
            result[k][1] = intervals[k][1];
        }
        return result;
    }
}