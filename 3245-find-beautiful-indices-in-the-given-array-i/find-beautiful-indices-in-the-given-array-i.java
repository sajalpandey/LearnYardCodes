class Solution {
    int p = 26, mod = 1000000007;
    //Write a hash function
    public long getHashCode(String str) {
        long ans = 0;
        for(int i=0; i<str.length(); i++) {
            int chInt = str.charAt(i) - 'a' + 1;
            ans = (ans * p + chInt) % mod;
        }
        return ans;
    }
    public long power(long a, long n) {
		if(n == 0)
			return 1l;
		long partialAns = power(a, n/2);
		
		if(n%2 == 0)
			return (partialAns * partialAns) % mod;
		return (((a * partialAns) % mod ) * partialAns) % mod;
	}
    public List<Integer> rabinKarp(String str, String pat) {
        List<Integer> res = new ArrayList<>();
        if(pat.length() > str.length())
            return res;
        long hs = getHashCode(str.substring(0, pat.length()));
        long hp = getHashCode(pat);

        if(hs == hp)
            res.add(0);
        //calculate power like charCode*31^pat.length()-1
        long powerW = power(p, pat.length()-1);

        for(int s = 1, e = pat.length(); e < str.length(); ++s, ++e) {
            int delCharInt = str.charAt(s-1) - 'a' + 1;

            //now update our has by removing sth char and add eth char

            hs = (hs - (powerW * delCharInt) % mod + mod) % mod;

            //add eth char
            int addCharInt = str.charAt(e) - 'a' + 1;
            hs = ((hs * p) % mod + addCharInt) % mod;

            if(hs == hp)
                res.add(s);
        }

        return res;
    }
    public int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (list.get(mid) == target)
                return mid;

            // If target is greater, ignore left half
            if (list.get(mid) < target)
                left = mid + 1;
            // If target is smaller, ignore right half
            else
                right = mid - 1;
        }

        // Target not found in list
        return -1;
    }
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        // System.out.println(s.length());
        // System.out.println(a.length());
        // System.out.println(b.length());
        List<Integer> v1 = rabinKarp(s, a);
        List<Integer> v2 = rabinKarp(s, b);
        List<Integer> ans = new ArrayList<>();

        for(int i = 0, j = 0; i < v1.size(); ++i){
        while(j < v2.size() && v1.get(i) > v2.get(j) && Math.abs(v1.get(i) - v2.get(j)) > k) j++;
        if(j < v2.size() && Math.abs(v1.get(i) - v2.get(j)) <= k) ans.add(v1.get(i));
        }
        return ans;
    }
}