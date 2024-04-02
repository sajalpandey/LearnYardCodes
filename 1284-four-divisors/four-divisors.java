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
        }
        if(n > 1)
            result *= 2;
        return result;
    }
    public static int sumOfFactors(int n) {
        // Initialize sum to store the sum of factors
        int sum = 0;
        // Iterate from 1 to n
        for (int i = 1; i <= n; ++i) {
            // If i is a divisor of n, add it to the sum
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
    public int sumFourDivisors(int[] nums) {
        // find max element
        int mx = 0;
        for (int num : nums) {
            mx = Math.max(mx, num);
        }

        int[] countDivisors = new int[mx + 1];//// for storing divisors and their sum
        int[] sumDivisors = new int[mx + 1];

        for (int i = 1; i <= mx; i++) {
            for (int j = i; j <= mx; j += i) {
                countDivisors[j]++;
                sumDivisors[j] += i;
            }
        }

        int sum = 0;
        for (int num : nums) {
            if (countDivisors[num] == 4) {
                sum += sumDivisors[num];
            }
        }

        return sum;
    }
}