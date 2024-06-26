class Solution {
    public boolean isPowerOfFour(int n) {
        if(n == 1)
            return true;
        int leftSetBit = 0;
        if((n & (n-1)) == 0) {
            while(n > 0){
                leftSetBit++;
                n = n >> 1;
            }
            if(leftSetBit%2 != 0)
                return true;
        }
        return false;
    }
}