class Solution {
    public boolean ispower(int n) {
        if(n<=0)
            return false;
        if(n==1)
            return true;
        if(n%3!=0)
            return false;
        return ispower(n/3);
    }
    public boolean isPowerOfThree(int n) {
        return ispower(n);
    }
}