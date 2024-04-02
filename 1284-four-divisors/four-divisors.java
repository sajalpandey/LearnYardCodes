class Solution {
    public int primeFactors(int n) {
        int result = 1;
        for(int i = 2; i*i <= n; ++i) {
            if(n%i != 0)
                continue;
            int power = 0;
            while(n%i == 0) {
                n /= i;
                power += 1;
            }
            result *= (power+1);
            //ans.put(i, power);
        }
        if(n > 1)
            result *= 2;
        //System.out.println("result = "+result);
        return result;
    }
    public static int sumOfFactors(int n) {
        // Initialize sum to store the sum of factors
        int sum = 0;
        // Iterate from 1 to n
        for (int i = 1; i <= n; i++) {
            // If i is a divisor of n, add it to the sum
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            if(primeFactors(nums[i])==4) {
                sum += sumOfFactors(nums[i]);
            }
        }
        return sum;
    }
}