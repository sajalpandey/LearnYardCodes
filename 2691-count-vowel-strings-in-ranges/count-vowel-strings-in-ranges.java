class Solution {
    public static boolean isVowel(char ch) {
        char lowerCh = Character.toLowerCase(ch);
        return lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u';
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int [] prefix = new int[words.length+1];
        int result[] = new int[queries.length];
        int count = 0, j=1;
        for(String str : words) {
            //System.out.println(str);
            if(isVowel(str.charAt(0)) && isVowel(str.charAt(str.length()-1))) {
                count++;
            }
            prefix[j++] = count;
        }

        for(int i=0; i<queries.length; i++) {
            result[i] = prefix[queries[i][1]+1] - prefix[queries[i][0]];
        }
        return result;
    }
}