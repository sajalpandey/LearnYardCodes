class Solution {
    public String getSmallestString(String str) {
        StringBuilder s = new StringBuilder(str);
        for(int i=0; i+1<s.length(); i++) {
            int e1 = s.charAt(i) - '0';
            int e2 = s.charAt(i+1) - '0';
            if(e1%2 == 0 && e2%2 == 0 && e1 > e2) {
                char temp = s.charAt(i+1);
                s.setCharAt(i+1, s.charAt(i));
                s.setCharAt(i, temp);
                return s.toString();
            } else if(e1%2 != 0 && e2%2 != 0 && e1 > e2) {
                char temp = s.charAt(i+1);
                s.setCharAt(i+1, s.charAt(i));
                s.setCharAt(i, temp);
                return s.toString();
            }
        }
        return s.toString();
    }
}