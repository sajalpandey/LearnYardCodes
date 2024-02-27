class Solution {
    class comp implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            if (a[1] < b[1])
                return 1;
            else if(a[1] > b[1])
                return -1;
            else
                return 0;
        }
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int result = 0;
        Arrays.sort(boxTypes, new comp());
        // for(int [] arr : boxTypes)
        //     System.out.println(arr[0]+" -- "+arr[1]);
        for(int [] arr : boxTypes) {
            //System.out.println(arr[0]+" -- "+arr[1]);
            if(arr[0] <= truckSize) {
                result += arr[0] * arr[1];
                truckSize -= arr[0];
            } else if(arr[0] > truckSize && truckSize > 0) {
                result += truckSize * arr[1];
                truckSize = 0;
            }
            if(truckSize==0)
                break;
        }
        return result;
    }
}