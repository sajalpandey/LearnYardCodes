class Solution {
    public int countAsterisks(String s) {
        int result = 0;
        int bars = 0;
        for(char c : s.toCharArray()) {
            if(c == '|')
                bars++;
            else if(c == '*') {
                if(bars%2==0)
                    result++;
            }
        }
        return result;
    }
}