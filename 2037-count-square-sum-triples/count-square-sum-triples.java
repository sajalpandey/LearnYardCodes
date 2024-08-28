class Solution {
    public int countTriples(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=1; i<=n; i++)
            map.put(i*i, i);
        
        int count = 0;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i < j && map.containsKey(i*i + j*j)) {
                    count++;
                }
            }
        }
        return (2*count);
    }
}