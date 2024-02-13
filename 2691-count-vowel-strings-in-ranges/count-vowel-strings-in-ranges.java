class Solution {
    public static boolean isVowel(char ch) {
        char lowerCh = Character.toLowerCase(ch);
        return lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u';
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int [] prefix = new int[words.length];
        int result[] = new int[queries.length];
        int count = 0, j=0;
        for(String str : words) {
            //System.out.println(str);
            if(isVowel(str.charAt(0)) && isVowel(str.charAt(str.length()-1))) {
                count++;
            }
            prefix[j++] = count;
        }

        for(int i=0; i<prefix.length; i++)
            System.out.print(prefix[i]+" ");
        System.out.println();
        for(int i=0; i<queries.length; i++) {
            result[i] = prefix[queries[i][1]] - prefix[queries[i][0]];
            int k = queries[i][0]; 
            if(isVowel(words[k].charAt(0)) && isVowel(words[k].charAt(words[k].length()-1))) {
                result[i]++;
            }
        }
        return result;
    }
}