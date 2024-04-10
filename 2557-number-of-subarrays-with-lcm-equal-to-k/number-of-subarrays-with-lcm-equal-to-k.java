class Solution {
    public int gcd(int a, int b) {
        if(b==0)
            return a;
        return gcd(b, a%b);
    }
    public int findLcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    public int subarrayLCM(int[] nums, int k) {
        int result = 0;
        for(int i=0; i<nums.length; i++) {
            int lcm = 1;
            for(int j=i; j<nums.length; j++) {
                lcm = findLcm(lcm, nums[j]);
                if(lcm == k)
                    result++;
                else if(lcm > k)
                    break;
            }
        }
        return result;
    }
}