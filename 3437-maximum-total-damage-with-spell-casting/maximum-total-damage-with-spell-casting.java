class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Long, Integer> freq = new HashMap<>();
        for(int i=0; i<power.length; i++)
            freq.put(1L*power[i], freq.getOrDefault(1L*power[i], 0) + 1);
        
        long[] spells = new long[freq.size()];
        int k = 0;
        for(long p : freq.keySet())
            spells[k++] = p;
        Arrays.sort(spells);
        
        long[] dp = new long[spells.length];

        dp[0] = spells[0] * freq.get(spells[0]);

        for(int i=1; i<spells.length; i++) {

            //store max result from previous state
            dp[i] = dp[i-1];
            int j = i-1;
            long curr = spells[i] * freq.get(spells[i]);
            while(j >= 0 && spells[i] - spells[j] <= 2)
                j--;

            if(j >= 0)
                dp[i] = Math.max(dp[i], curr + dp[j]);
            else
                dp[i] = Math.max(dp[i], curr);
        }

        return dp[spells.length-1];
    }
}