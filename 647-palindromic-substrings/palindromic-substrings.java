class Solution {
    public int countSubstrings(String str) {
        int count = 0;
        int n = str.length();
        for(int i=0; i<n; i++) {
            count++;
            int s = i-1, e = i+1;
            while(s >= 0 && e < n) {
                if(str.charAt(s) != str.charAt(e))
                    break;
                count++;
                s--;
                e++;
            }
            s = i; e = i+1;
            while(s >= 0 && e < n) {
                 if(str.charAt(s) != str.charAt(e))
                    break;
                count++;
                s--;
                e++;
            }
        }
        return count;
    }
}