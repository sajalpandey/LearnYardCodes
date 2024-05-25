class TrieNode {
    Map<Character, TrieNode> child;
    int endWord;

    TrieNode() {
        this.child = new HashMap<>();
        this.endWord = 0;
    }
}
class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()) {
            //if this char is not in trie then create one
            //else move to childeren of it

            if(!curr.child.containsKey(ch))
                curr.child.put(ch, new TrieNode());
            curr = curr.child.get(ch);
        }

        curr.endWord += 1;
    }
    public void dfsSearch(TrieNode curr, StringBuilder currStr, List<String> ans) {
        if(ans.size() == 3)
            return;
        if(curr.endWord >= 1)
            ans.add(currStr.toString());

        //iterate for each char in increasing order wheater exists in trie or not
        //if Yes then append in currStr and call DFS again

        for(char ch='a'; ch<='z'; ch++){
            if(!curr.child.containsKey(ch))
                continue;
            //if Yes
            currStr.append(ch);
            dfsSearch(curr.child.get(ch), currStr, ans);
            currStr.deleteCharAt(currStr.length()-1);
        }
    }
    public List<String> findTop3Words(String prefix) {
        //now iterate over each word and reach till end of the prefix in trie node
        TrieNode curr = root;
        for(char ch : prefix.toCharArray()) {
            //if prefix char not found return empty
            if(!curr.child.containsKey(ch))
                return new ArrayList<>();
            curr = curr.child.get(ch);
        }
        //Now we traversed till prefix , from here we can find different words
        //now initiate a DFS search
        StringBuilder currStr = new StringBuilder(prefix);
        List<String> ans = new ArrayList<>();
        dfsSearch(curr, currStr, ans);
        return ans;
    }

}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie obj = new Trie();
        //Insert all strings in Trie 
        for(String str : products)
            obj.insert(str);
        
        //Now for each substring of searchWord find top3Suggestions
        List<List<String>> result = new ArrayList<>();
        for(int i=1; i<=searchWord.length(); i++) {
            result.add(obj.findTop3Words(searchWord.substring(0,i)));
        }

        return result;
    }
}