class Solution {
    public static void helper(List<List<Integer>> result,List<Integer> temp,int [] nums, int i,int j) {
        if(i>=j) {
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        helper(result,temp,nums,i+1,j);
        temp.remove(temp.size()-1);
        helper(result,temp,nums,i+1,j);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        /**
        [1,2,3] , n = 3 subset = 2^3 = 8 (0 -- 7)
        [0,1,2] 0,1,2,3,4 --> 100 6--> 110
        000 - []
        100 - [1]
        010 - [2]
        001 - [3]
        110 - [1,2]
        101 - [1,3]
        011 - [2,3]
        111 - [1,2,3]
         */
        int n = nums.length;
        for(int i=0; i<(1 << n); i++) {
            //System.out.println("i = "+i);
            List<Integer> temp = new ArrayList<>();
            for(int j=0; j<n; j++) {
                int bit = (1 << j);
                //System.out.println("bit = "+bit);
                if((i & bit) != 0) {
                    //System.out.println("number = "+i+" --set bit is = "+bit);
                    //Jth bit is set
                    temp.add(nums[j]);
                }
            }
            result.add(new ArrayList<>(temp));
        }
        return result;
    }
}