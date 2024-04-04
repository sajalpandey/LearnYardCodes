class Solution {
    public int findGcd(int a, int b) {
        if(b==0)
            return a;
        return findGcd(b, a%b);
    }
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : deck)
            map.put(ele,map.getOrDefault(ele,0)+1);
        int gcd = 0;
        for(int val : map.values()) {
            gcd = findGcd(gcd, val);
        }
        if(gcd > 1)
            return true;
        return false;
    }
}