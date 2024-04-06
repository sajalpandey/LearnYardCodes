class Solution {
    public int MOD = 1337;
    public int mul(int a, int b) {
        return ((a%MOD) * (b%MOD))%MOD;
    }
    public int powerFn(int a, int n) {
        if(n == 0)
            return 1;
        int partialAns = powerFn(a, n/2);

        partialAns = mul(partialAns, partialAns);
        if(n%2==0)
            return partialAns;
        return mul(partialAns, a);
    }
    public int superPow(int a, int[] b) {
        int result = 1;
        for(int i=0; i<b.length; ++i){
            result = mul(powerFn(result, 10) ,powerFn(a, b[i]));
        }
        return result;
    }
}