
class Solution {
    public String reverseWords(String s) {
        StringBuilder str = new StringBuilder(s.trim());
        str.reverse();
        int i=0;
        StringBuilder result = new StringBuilder();
        while(i < str.length()) {
            StringBuilder temp = new StringBuilder();
            while(i < str.length() && str.charAt(i) != ' ')
                temp.append(str.charAt(i++));
            result.append(temp.reverse());
            if(i != str.length())
                result.append(' ');
            while(i < str.length() && str.charAt(i) == ' ')
                temp.append(str.charAt(i++));
        }
        
        return result.toString();
    }
}