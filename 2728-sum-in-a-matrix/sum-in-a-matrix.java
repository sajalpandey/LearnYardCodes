class Solution {
    public class comp implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            return i2 - i1;
        }
    }
    static class DescendingComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return Integer.compare(o2[0], o1[0]);
        }
    }
    public int matrixSum(int[][] nums) {
        /**
        Sort th 2d array in decending order 
        the traverse column wise find max of each column
        add this max for each column in our answer
         */
        int mx = 0, result = 0;
        //Arrays.sort(nums);
        //Arrays.sort(nums, new DescendingComparator());
        
        int row = nums.length;
        int col = nums[0].length;
        // Display the sorted 2D array
        for (int[] rw : nums) {
            Arrays.sort(rw);
            // for (int element : rw) {
            //     System.out.print(element + " ");
            // }
            // System.out.println();
        }
        for(int i=0; i<col; ++i) {
            mx = 0;
            for(int j=0; j<row; ++j) {
                mx = Math.max(mx,nums[j][i]);
            }
            result += mx;
        }
        return result;
    }
}