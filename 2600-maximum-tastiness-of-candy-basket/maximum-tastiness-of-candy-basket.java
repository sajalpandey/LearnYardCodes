class Solution {
    public boolean isPossible(int[] price, int mid, int k) {
        int last = price[0];
        k--;
        for(int i=0; i<price.length && k>0; ++i){
            if((last + mid) <= price[i]) {
                // we can take this candy in the basket
                last = price[i];
                k--;
            }
        }
        return (k > 0 ? false : true);
    }
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int lo = 0, hi = Integer.MAX_VALUE;
        int ans = 0;
        while(lo <= hi) {
            int mid = lo + (hi - lo)/ 2;
            boolean result = isPossible(price,mid,k);
            if(result == true) {
                ans = mid;
                lo = mid + 1;
            } else
                hi = mid -1;
        }
        return ans;
    }
}