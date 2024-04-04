class Solution {
    public int gcd(int a, int b) {
        if(b == 0)
            return a;
        return gcd(b, a%b);
    }
    public int findGCD(int[] nums) {
        int smallest = 1000, largest = 1;
        for(int i=0; i<nums.length; i++) {
            smallest = Math.min(smallest, nums[i]);
            largest = Math.max(largest, nums[i]);
        }
        return gcd(largest, smallest);
    }
}