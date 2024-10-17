class Solution {
    public int maxProfit(int[] prices) {
        /**
        Easily can be done with two loops

         */
        // Other is to find max ele on right 
        int n = prices.length;
        int maxP = 0, rmax = prices[n-1];
        for(int i=n-1; i>=0; i--) {
            rmax = Math.max(rmax, prices[i]);
            maxP = Math.max(maxP, (rmax - prices[i]));
        }
        return maxP;
    }
}