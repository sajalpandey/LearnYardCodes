class Solution {
    public int countTriples(int n) {
        HashSet<Integer> map = new HashSet<>();
        for(int i=1; i<=n; i++)
            map.add(i*i);
        
        int count = 0;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i < j && map.contains(i*i + j*j)) {
                    count++;
                }
            }
        }
        return (2*count);
    }
}