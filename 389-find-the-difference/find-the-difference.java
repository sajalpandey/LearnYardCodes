class Solution {
    public static String sortString(String str) {
        // Convert the string to a character array
        char[] charArray = str.toCharArray();

        // Sort the character array
        Arrays.sort(charArray);

        // Create a new string from the sorted character array
        return new String(charArray);
    }
    public char findTheDifference(String s, String t) {
        String sortedS = sortString(s);
        String sortedT = sortString(t);
        
        int i=0;
        for(i=0; i<sortedS.length(); i++) {
            if(sortedS.charAt(i)!=sortedT.charAt(i))
                return sortedT.charAt(i);
        }
        //System.out.println("sajal = "+t.charAt(t.length()-1));
        return (sortedT.charAt(sortedT.length()-1));
    }
}