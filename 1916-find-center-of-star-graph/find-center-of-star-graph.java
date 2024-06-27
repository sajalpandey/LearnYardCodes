class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        int[] d = new int[n+2];
        for(int[] row : edges) {
            if(++d[row[0]] == n)
                return row[0];
            if(++d[row[1]] == n)
                return row[1];
        }
        return 0;
    }
}