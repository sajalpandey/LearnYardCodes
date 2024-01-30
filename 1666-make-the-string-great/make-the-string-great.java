class Solution {
    public String makeGood(String s) {
        StringBuilder result = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
             if(result.length()==0) {
                 result.append(s.charAt(i));
             } else {
                 if(Math.abs(s.charAt(i)-result.charAt(result.length()-1))==32){
                     result.deleteCharAt(result.length()-1);
                 } else {
                     result.append(s.charAt(i));
                 }
             }
        }
        return result.toString();
    }
}