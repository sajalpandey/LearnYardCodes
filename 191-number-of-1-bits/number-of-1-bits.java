class Solution {
    public int hammingWeight(int n) {
        int ans = 0;
        int m = 1;
        while(n!=0) {
            if((n&m) != 0)
                ans++;
            n = n>>1;
        }
        return ans;
    }
}