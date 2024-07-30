class Solution {
    public int minimumDeletions(String s) {
        int c1 = 0, c2 = 0;
        int result = Integer.MAX_VALUE;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'a')
                c1++;
        }
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'a')
                c1--;
            result = Math.min(result, c1+c2);
            if(s.charAt(i) == 'b')
                c2++;
        }
        return result;
    }
}