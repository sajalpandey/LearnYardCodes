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
        // for(int[] arr : points)
        //     System.out.println(arr[0]+" - "+arr[1]);
        
        int i=0,j=1;
        while(j < points.length) {
            //System.out.println("points[j][0] = "+points[j][0]+" -- points[i][1] = "+points[i][1]);
            if(points[j][0] <= points[i][1])
                j++;
            else {
                //System.out.println("j = "+j+" -- i = "+i);
                result++;
                i = j++;
                //System.out.println("j = "+j+" -- i = "+i);
            }
        }

        return ++result;
    }
}