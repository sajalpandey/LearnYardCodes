class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        //merge the meetings 
        int n = meetings.length, result = 0;
        int prev = 0;
        result += meetings[0][0] - 1;
        for(int i=1; i<n; i++) {
            //merge case
            if(meetings[i][0] <= meetings[prev][1]) {
                meetings[prev][1] = Math.max(meetings[i][1], meetings[prev][1]);
            } else {
                result += (meetings[i][0] - meetings[prev][1] - 1);
                prev = i;
            }
        }
        result += days - meetings[prev][1];
        return result;
    }
}