class Solution {
    public int myAtoi(String s) {
        long result = 0;
        StringBuilder str = new StringBuilder(s.trim());
        if(str.length() == 0)
            return 0;
        int sign = 1;
        int i = 0;
        if(str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if(str.charAt(i) == '+')
            i++;
        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if(result * sign >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if(result * sign <= Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }
        if(result * sign >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if(result * sign <= Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)result*sign;
    }
}