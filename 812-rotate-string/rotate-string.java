class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length())
            return false;
        char[] c1 = s.toCharArray();
        char[] c2 = goal.toCharArray();
        for(int i=0; i<c1.length; i++) {
            int index = i;
            boolean flag = true;
            for(int j=0; j<c2.length; j++) {
                if(c1[index%c1.length] != c2[j]) {
                    flag = false;
                    break;
                }
                index++;
            }
            if(flag)
                return flag;
        }
        return false;
    }
}