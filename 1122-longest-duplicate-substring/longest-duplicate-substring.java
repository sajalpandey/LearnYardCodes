class Solution {
    int p = 31, mod = 1000000007, m2 = 998244353;
    //Write a hash function
    public long getHashCode(String str, int mod) {
        long ans = 0;
        for(int i=0; i<str.length(); i++) {
            int chInt = str.charAt(i) - 'a' + 1;
            ans = (ans * p + chInt) % mod;
        }
        return ans;
    }
    public long power(long a, long n, int mod) {
		if(n == 0)
			return 1l;
		long partialAns = power(a, n/2, mod);
		
		if(n%2 == 0)
			return (partialAns * partialAns) % mod;
		return (((a * partialAns) % mod ) * partialAns) % mod;
	}
    public String getDuplicatedString(String str, int len) {
        HashSet<Long> set = new HashSet<>();
        HashSet<Long> set2 = new HashSet<>();
        long hs1 = getHashCode(str.substring(0, len), mod);
        long hs2 = getHashCode(str.substring(0, len), m2);
        set.add(hs1);
        set2.add(hs2);
        //calculate power like charCode*31^pat.length()-1
        long powerW = power(p, len-1, mod);
        long powerW2 = power(p, len-1, m2);
        for(int s = 1, e = len; e < str.length(); ++s, ++e) {
            int delCharInt = str.charAt(s-1) - 'a' + 1;

            //now update our has by removing sth char and add eth char

            hs1 = (hs1 - (powerW * delCharInt) % mod + mod) % mod;
            hs2 = (hs2 - (powerW2 * delCharInt) % m2 + m2) % m2;
            
            //add eth char
            int addCharInt = str.charAt(e) - 'a' + 1;
            hs1 = ((hs1 * p) % mod + addCharInt) % mod;
            hs2 = ((hs2 * p) % m2 + addCharInt) % m2;

            if(set.contains(hs1) && set2.contains(hs2)) {
                return str.substring(s, e+1);
            }
            set.add(hs1);
            set2.add(hs2);
        }
        return "";
    }
    public String longestDupSubstring(String s) {
        /**
        0. We do binary search for every possible length
        1. We will check if duplicated string is present for this length or not
        2. To check duplicate we will use RABIN KARP (rolling hash)
        3. if hash of current length string is already present we will return the string of
            that length
        */
        String result = "";
        int l = 1, e = s.length()-1;
        while(l <= e) {
            int mid = (l + e) / 2;
            System.out.println("mid = "+mid);
            String temp = getDuplicatedString(s, mid);
            if(temp.length() > 0) {
                //we have found the duplicated string
                result = temp;
                l = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return result;
    }
}