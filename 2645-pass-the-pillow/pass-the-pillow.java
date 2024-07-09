class Solution {
    public int passThePillow(int n, int time) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1; i<=n; i++)
            arr.add(i);
        for(int i=n-1; i>=1; i--)
            arr.add(i);
        
        n = 2*n-2;
        int index = time % n;
        return arr.get(index);
    }
}