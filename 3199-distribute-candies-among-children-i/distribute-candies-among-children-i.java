class Solution {
    public int distributeCandies(int n, int limit) {
        int ans = 0;

        for(int i=0; i<=limit && i<=n; i++) {
            for(int j=0; j<=limit && j<=n; j++) {
                for(int k=0; k<=limit && k<=n; k++)
                    if((i+j+k) == n)
                    ans++;
            }
        }
        return ans;
    }
}