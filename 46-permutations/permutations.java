class Solution {
    public static void swap(int[] array, int index1, int index2) {
        // Temporary storage of the first element
        int temp = array[index1];
        // Assign the second element to the first element's position
        array[index1] = array[index2];
        // Assign the stored first element to the second element's position
        array[index2] = temp;
    }
    public static void helper(List<List<Integer>> result,List<Integer> temp,int [] nums, int i) {
        if(i == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int num : nums) {
                perm.add(num);
            }
            result.add(perm);
            return;
        }
        
        for(int j=i; j<nums.length; j++) {
            swap(nums,i,j);
            helper(result,temp,nums,i+1);
            swap(nums,i,j);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        //result.add(temp);
        helper(result,temp,nums,0);
        return result;
    }
}