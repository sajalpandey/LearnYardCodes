class Solution {
    public String largestNumber(int[] nums) {
        int j;
        int n = nums.length;
        for(j=0; j<n; ++j) {
            if(nums[j]!=0)
                break;
        }
        if(j==n)
            return "0";
        StringBuilder result = new StringBuilder();
        Integer[] newArr = new Integer[nums.length];
        for(int i=0; i<n; ++i)
            newArr[i] = nums[i];
        Arrays.sort(newArr, (a,b) -> ((b+""+a).compareTo(a+""+b)));
        for(int ele : newArr)
            result.append(ele);
        return result.toString();
    }
}