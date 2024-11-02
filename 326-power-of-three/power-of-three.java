class Solution {
    public boolean isPowerOfThree(int n) {
        while(n >= 3) {
            if(n%3 == 0)
                n /= 3;
            else
                break;
        }
        if(n == 1)
            return true;
        return false;
    }
}