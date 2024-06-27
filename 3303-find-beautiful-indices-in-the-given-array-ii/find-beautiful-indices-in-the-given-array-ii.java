class Solution {
    int p = 26, mod = 998244353;
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
public boolean binary_search(int target,int k,List<Integer> a_index,List<Integer> b_index){
        
        int l = 0;
        int r = b_index.size()-1;
        
        int left  = target - k;
        int right = target + k;
        

        while( l <= r){
            
            int mid   = (l + (r-l)/2);
            int val   = b_index.get(mid);

            if( val >= left && val <= right   ) return true;
            
            if( val < left )        l = mid + 1;
            else if ( val > right ) r = mid - 1;
                        
        }
        
        return false;
                
    }

    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> p = rabinKarp(s, a);
        List<Integer> q = rabinKarp(s, b);
        List<Integer> ans = new ArrayList<>();

        for(int ele : p)
            System.out.print(ele+" ");
        System.out.println();
        for(int ele : q)
            System.out.print(ele+" ");
        for(int i=0; i < p.size(); ++i){
             
            if( binary_search(p.get(i),k,p,q) ) 
                  ans.add(p.get(i));
         
         }
        return ans;
    }
}