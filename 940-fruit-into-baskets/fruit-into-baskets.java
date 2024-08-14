class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> set = new HashMap<>();
        int maxLen = 0;
        int j=0, i=0, k = 2, n = fruits.length;
        while(j < n) {
            set.put(fruits[j], set.getOrDefault(fruits[j], 0)+1);
            while(i < j && set.size() > 2) {
                int f = set.get(fruits[i]);
                if(--f == 0)
                    set.remove(fruits[i]);
                else
                    set.put(fruits[i], f);
                i++;
            } 
            maxLen = Math.max(maxLen, (j-i+1));
            j++;
        }
        return maxLen;
    }
}