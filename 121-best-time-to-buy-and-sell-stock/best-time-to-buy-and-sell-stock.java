class Solution {
    public int maxProfit(int[] prices) {
        int mx = Integer.MIN_VALUE;
        int result = 0;
        for(int i=prices.length-1; i>=0; i--) {
            mx = Math.max(mx,prices[i]);
            if(result < (mx - prices[i]))
                result = mx - prices[i];
        }
        return result;
    }
}