class Solution {
    public double power(double x, int n) {
        if(n == 0)
            return 1.0;
        double partialAns = power(x, n/2);
        if(n % 2 == 0)
            return (partialAns * partialAns);
        return (x * partialAns * partialAns);
    }
    public double myPow(double x, int n) {
        double result = power(x, Math.abs(n));
        if(n < 0)
            return (1.0/result);
        return result;
    }   
}