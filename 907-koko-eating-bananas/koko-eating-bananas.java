class Solution {
    public int isAnswer(int[] piles, int k, int h) {
        int result = 0;
        
        for(int i=0; i<piles.length; i++) {
            double p = (int)Math.ceil((double) piles[i] / k);
            result += p;
        }
        System.out.println("k = "+k+" -- result = "+result);
        return result;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int lo = 1, hi = Integer.MIN_VALUE;
        for(int ele :  piles)
            hi = Math.max(hi, ele);
        int result = 1;
        int speed = hi;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int ans = isAnswer(piles,mid,h);
            if(ans > h) {
                lo = mid + 1;
            }
            else {
                result = mid;
                hi = mid - 1;
            }
        }
        return result;
    }
}