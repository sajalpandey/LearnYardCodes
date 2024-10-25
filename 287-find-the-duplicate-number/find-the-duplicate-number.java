class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele : nums){
            if(set.contains(ele))
                return ele;
            set.add(ele);
        }
        return -1;
    }
}