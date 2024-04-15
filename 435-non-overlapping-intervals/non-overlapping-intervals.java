class Solution {
    class Pair {
        int key;
        int value;
        Pair(int k, int v) {
            key = k;
            value = v;
        }
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Stack<Pair> st = new Stack<>();
        Arrays.sort(intervals, (a,b) -> (a[1]-b[1]));
        
        int count = 0;
        for(int i=0; i<intervals.length; ++i) {
            if(!st.isEmpty() && intervals[i][0] < st.peek().value) {
                //int key = st.peek().key;
                count++;
                //st.pop();
                //st.push(new Pair(key, intervals[i][1]));
            } else {
                st.push(new Pair(intervals[i][0], intervals[i][1]));
            }
        }
        return count;
    }
}