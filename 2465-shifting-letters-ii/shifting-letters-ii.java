class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int prefix[] =  new int[s.length()+1];
        for(int i=0; i<shifts.length; i++) {
            if(shifts[i][2]==1) {
                prefix[shifts[i][0]]++;
                if(shifts[i][1]<s.length()-1)
                    prefix[shifts[i][1]+1]--;
            } else {
                prefix[shifts[i][0]]--;
                if(shifts[i][1]<s.length()-1)
                    prefix[shifts[i][1]+1]++;
            }
        }
        int sum = 0;
        StringBuilder result = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            sum += prefix[i];
            int ascii = (s.charAt(i)-'a'+sum)%26;
            if(ascii < 0)
                ascii += 26;
            result.append((char)(ascii+'a'));
        }
        return result.toString();
    }
}