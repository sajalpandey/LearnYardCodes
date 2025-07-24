class Solution {
    public boolean checkVowel(char ch) {
        return (ch == 'a' || ch == 'i' || ch == 'e' || ch == 'o' || ch == 'u');
    }
    public int maxVowels(String s, int k) {
        int i = 0;
        int count = 0, ans = 0;
        while(i < k) {
            if(checkVowel(s.charAt(i)))
                count++;
            i++;
        }
        ans = Math.max(count, ans);
        while(i < s.length()) {
            if(checkVowel(s.charAt(i-k)))
                count--;
            if(checkVowel(s.charAt(i)))
                count++;
            ans = Math.max(count, ans);
            i++;
        }
        return ans;
    }
}