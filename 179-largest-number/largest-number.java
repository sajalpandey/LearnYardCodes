class Solution {
    public String largestNumber(int[] nums) {
        int j;
        for(j=0; j<nums.length; j++) {
            if(nums[j]!=0)
                break;
        }
        if(j==nums.length)
            return "0";
        StringBuilder result = new StringBuilder();
        Integer[] newArr = new Integer[nums.length];
        for(int i=0; i<nums.length; i++)
            newArr[i] = nums[i];
        Arrays.sort(newArr, (a,b) -> ((b+""+a).compareTo(a+""+b)));
        for(int ele : newArr)
            result.append(ele);
        return result.toString();
    }
}