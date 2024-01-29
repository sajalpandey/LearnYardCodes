class Solution {
    public String reverseOnlyLetters(String s) {
        int i=0, j=s.length()-1;
        StringBuilder result = new StringBuilder();
        result.append(s);
        while(i<j) {
            // if both char at I & j are letter then we will swap them
            if(Character.isLetter(result.charAt(i)) && Character.isLetter(result.charAt(j))) {
                char temp = result.charAt(i);
                result.setCharAt(i, result.charAt(j));
                result.setCharAt(j, temp); 
                i++;
                j--;
            } else if(!Character.isLetter(result.charAt(i))) {
                i++;
            } else if(!Character.isLetter(result.charAt(j))) {
                j--;
            } else {
                i++;j--;
            }
        }
        return result.toString();
    }
}