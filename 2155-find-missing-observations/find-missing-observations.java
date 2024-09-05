class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        // (12+4m)/7 = 3
        int m = rolls.length;
        int sumofRolls = Arrays.stream(rolls).sum();
        int remSum = mean * (n + m) - sumofRolls;
        if(remSum > 6*n || remSum < n)
            return new int[]{};
        
        int[] ans = new int[n];
        Arrays.fill(ans, remSum/n);
        for(int i=0; i<remSum%n; i++)
            ans[i] += 1;
        return ans;
    }
}