class Pair {
    String s;
    int steps;
    Pair(String s, int ss) {
        this.s = s;
        this.steps = ss;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String str : wordList)
            set.add(str);
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        if(set.contains(beginWord))
            set.remove(beginWord);
        
        while(!q.isEmpty()) {
            Pair pair = q.poll();
            if(pair.s.equals(endWord))
                return pair.steps;
            
            //now for the above word change each word in it
            for(int i=0; i<pair.s.length(); i++) {
                StringBuilder str = new StringBuilder(pair.s);

                for(char ch = 'a'; ch <= 'z'; ch++) {
                    str.setCharAt(i, ch);

                    if(set.contains(str.toString())) {
                        set.remove(str.toString());
                        q.add(new Pair(str.toString(), pair.steps+1));
                    }
                }
            }
        }
        //if not found
        return 0;
    }
}