class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (a[1]-b[1]));

        int count = 0;
        int i = 0, j = 1;
        while(j < intervals.length) {
            if(intervals[j][0] < intervals[i][1])
                count++;
            else {
                i = j;
            }
            j++;
        }
        return count;
    }
}