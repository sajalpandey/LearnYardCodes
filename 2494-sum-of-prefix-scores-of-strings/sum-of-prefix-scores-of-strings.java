class TrieNode {
    Map<Character, TrieNode> child;
    int endWord;
    int freq;

    TrieNode() {
        this.child = new HashMap<>();
        this.endWord = 0;
        this.freq = 0;
    }
}
class Solution {
    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()) {
            //if this char is not in trie then create one
            //else move to childeren of it

            if(!curr.child.containsKey(ch))
                curr.child.put(ch, new TrieNode());
            curr = curr.child.get(ch);
            curr.freq += 1;
        }

        curr.endWord += 1;
    }

    public int search(String word) {
        TrieNode curr = root;
        int prefixValue = 0;
        for(char ch : word.toCharArray()) {
            //if this char is not in trie then return false
            //else move to childeren of it
            if(!curr.child.containsKey(ch))
                return prefixValue;
            curr = curr.child.get(ch);
            prefixValue += curr.freq;
        }
        return prefixValue;
        //return (curr.endWord >= 1) ? true : false;
    }

    public int[] sumPrefixScores(String[] words) {
        int n = words.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        //Insert into trie
        for(String str : words)
            insert(str);
        //Search in Trie
        for(int i=0; i<words.length; i++) {
            int prefix = Math.max(1, search(words[i]));
            result[i] = prefix;
        }
        return result;
    }
}