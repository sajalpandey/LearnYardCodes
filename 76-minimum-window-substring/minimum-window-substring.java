class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        for(char ch : t.toCharArray()) {
            freq[ch]++;
        }
        int i = 0, j = 0;
        int count = t.length();
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0, endIndex = 0;
        while(j < s.length()) {
            char ch = s.charAt(j);
            if(freq[ch] > 0) {
                //means character was also present in b
                count--;
            }
            freq[ch]--;
            System.out.println("minLen = "+minLen+" count = "+count);
            if(count == 0) {
                //found all character of t in s, time to shrink the window
                while(count == 0) {
                    
                    if(minLen > (j - i)){
                        minLen = j - i;
                        startIndex = i;
                        endIndex = j;
                    }
                    freq[s.charAt(i)]++;
                    if(freq[s.charAt(i)] > 0) {
                        count++;
                    }
                    i++;
                }
            }
            j++;
        }
        return (minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, endIndex+1));
    }
}