class Solution {
    public String largestGoodInteger(String nums) {
        String result = "";
        for(int i=2; i<nums.length(); i++) {
            if(nums.charAt(i)==nums.charAt(i-1) && nums.charAt(i)==nums.charAt(i-2)) {
                String substr = nums.substring(i-2,i+1);
                if(substr.compareTo(result) > 0)
                    result = substr;
            }
        }
        return result;
    }
}