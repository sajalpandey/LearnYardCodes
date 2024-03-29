class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character,Integer> map = new HashMap<>();
        int count = 0;
        for(char c : chars.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);
        for(int i=0; i<words.length; ++i) {
            String str = words[i];
            boolean flag = true;
            HashMap <Character,Integer> temp = new HashMap(map);
            for(int j=0; j<str.length(); ++j) {
                if(temp.containsKey(str.charAt(j))) {
                    //decrease freq of char
                    int freq = temp.get(str.charAt(j));
                    if(freq == 1)
                        temp.remove(str.charAt(j));
                    else
                        temp.put(str.charAt(j),freq-1);
                } else {
                    flag = false;
                    break;
                }
            }
            if(flag==true) {
                //System.out.println("str = "+str);
                count += str.length();
            }
                
        }
        return count;
    }
}