class Solution {
    public int longestPalindrome(String s) {
        String str = s;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : str.toCharArray())
            map.put(ch, map.getOrDefault(ch,0)+1);
        int result = 0;
        int maxOddFreq = -1;
        for(char ch : map.keySet()) {
            int freq = map.get(ch);
            if(freq%2==0)
                result += freq;
            else {
                maxOddFreq = Math.max(maxOddFreq, freq);
                result +=  freq - 1;
            }
        }

        return (maxOddFreq==-1) ? result : ++result;
    }
}