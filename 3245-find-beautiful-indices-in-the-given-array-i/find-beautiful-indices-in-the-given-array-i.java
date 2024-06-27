class Solution {
    public List<Integer> strStr(String haystack, String needle) {
        int n = needle.length();
        List<Integer> l = new ArrayList<>();
        for(int i=0; i<haystack.length(); i++) {
            int j = i+n;
            if(j <= haystack.length() && haystack.substring(i,j).equals(needle))
                l.add(i);
        }
        return l;
    }
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> p = strStr(s, a);
        List<Integer> q = strStr(s, b);
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<p.size(); i++) {
            for(int j=0; j<q.size(); j++) {
                if(Math.abs(p.get(i)-q.get(j)) <= k){
                    ans.add(p.get(i));
                    break;}
            }
        }
        return ans;
    }
}