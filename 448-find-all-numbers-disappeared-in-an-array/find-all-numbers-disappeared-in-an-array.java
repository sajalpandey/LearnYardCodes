class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            while(nums[i]!=(i+1) && nums[i]!=nums[nums[i]-1]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=(i+1))
                result.add(i+1);
        }
        return result;
    }
}