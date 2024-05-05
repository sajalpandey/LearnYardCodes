class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        HashMap<Integer, int[]> map = new HashMap<>();
        //Generate all possible substring and store in map
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '0') {
                map.putIfAbsent(0, new int[] {i,i});
                continue;
            }
            int number = 0;

            for(int j=i; j<s.length() && j<(i+32); j++) {
                number = (number << 1) + (s.charAt(j) - '0');
                map.putIfAbsent(number, new int[] {i, j});
            }
        }
        //Now search for every val in map 
        int[][] result = new int[queries.length][2];
        for(int i=0; i<queries.length; i++) {
            int val = queries[i][0] ^ queries[i][1];
            result[i] = map.getOrDefault(val, new int[]{-1, -1});
        }
        return result;
    }
}