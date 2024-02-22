class Solution {
    public static void helper(List<List<Integer>> result,List<Integer> temp,int [] nums, int i,int j) {
        result.add(new ArrayList<>(temp));
        for(int k=i; k<=j; k++) {
            temp.add(nums[k]);
            helper(result,temp,nums,++i,j);
            temp.remove(temp.size()-1);
        }

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        //result.add(temp);
        helper(result,temp,nums,0,nums.length-1);
        return result;
    }
}