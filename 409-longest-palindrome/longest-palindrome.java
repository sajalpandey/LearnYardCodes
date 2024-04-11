class Solution {
    public int longestPalindrome(String s) {
        String str = s;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : str.toCharArray())
            map.put(ch, map.getOrDefault(ch,0)+1);
        int result = 0;
        int maxOddFreq = -1;
        for(char ch : map.keySet()) {
            if(map.get(ch)%2==0)
                result += map.get(ch);
            else if(map.get(ch)%2!=0){
                maxOddFreq = Math.max(maxOddFreq, map.get(ch));
                result +=  map.get(ch) - 1;
            }
        }
        if(maxOddFreq==-1)
            return result;
        return (++result);   
    }
}