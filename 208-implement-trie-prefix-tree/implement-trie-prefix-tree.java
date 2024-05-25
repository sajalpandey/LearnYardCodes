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
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()) {
            //if this char is not in trie then return false
            //else move to childeren of it
            if(!curr.child.containsKey(ch))
                return false;
            curr = curr.child.get(ch);
        }
        return (curr.endWord >= 1) ? true : false;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char ch : prefix.toCharArray()) {
            //if this char is not in trie then return false
            //else move to childeren of it
            if(!curr.child.containsKey(ch))
                return false;
            curr = curr.child.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */