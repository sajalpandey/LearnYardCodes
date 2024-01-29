class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int freq[] = new int[256];
        for(char c : jewels.toCharArray()) {
            freq[c - '0']++;
        }
        int count = 0;
        for(char c : stones.toCharArray()) {
            if(freq[c - '0'] > 0)
                count++;
        }
        return count;
    }
}