class Solution {
    public String clearStars(String s) {
        List<List<Integer>> map = new ArrayList<>();
        int n = s.length();
        boolean[] marked = new boolean[n];
        Arrays.fill(marked, true);
        for(int i=0; i<26; i++) {
            map.add(new ArrayList<>());
        }

        for(int j=0; j<n; j++) {
            char ch =  s.charAt(j);
            if(ch == '*') {
                //now we need to delete smallest character
                //if we have more than 1 occurence od char remove the frequent added
                marked[j] = false;
                for(int i=0; i<26; i++) {
                    if(map.get(i).size() > 0) {
                        //remove the last index from arraylist
                        marked[map.get(i).get(map.get(i).size() - 1)] = false;
                        map.get(i).remove(map.get(i).size() - 1);
                        break;
                    }
                }
            } else {
                // Add the character and its index 
                //System.out.println((ch - 'a'));
                map.get(ch - 'a').add(j);
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            if(marked[i])
                result.append(s.charAt(i));
        }
        return result.toString();
    }
}