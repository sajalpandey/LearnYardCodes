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
        for(int i=1; i<prefix.length; i++)
            prefix[i] += prefix[i-1];
        StringBuilder result = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            //System.out.println(prefix[i] );
            int ascii = (s.charAt(i)-'a'+prefix[i])%26;
            if(ascii < 0)
                ascii += 26;
            //System.out.println(ascii);
            //System.out.println(ascii);
            result.append((char)(ascii+'a'));
        }
        return result.toString();
    }
}