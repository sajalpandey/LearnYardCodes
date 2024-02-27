class Solution {
    class comp implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            if (a[1] > b[1])
                return 1;
            else if(a[1] < b[1])
                return -1;
            else
                return 0;
        }
    }
    public int findMinArrowShots(int[][] points) {
        int result = 0;
        Arrays.sort(points, new comp());
        int i=0,j=1;
        while(j < points.length) {
            if(points[j][0] <= points[i][1])
                j++;
            else {
                result++;
                i = j++;
            }
        }
        return ++result;
    }
}