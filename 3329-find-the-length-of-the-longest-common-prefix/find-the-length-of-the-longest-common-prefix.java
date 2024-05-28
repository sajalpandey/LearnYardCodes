class TrieNode {
	TrieNode[] child = new TrieNode[10];
}

class Solution {
    TrieNode root = new TrieNode();

    public void insert(int num) {
		TrieNode curr = root;
        String str = Integer.toString(num);
		for (char ch : str.toCharArray()) {
			// if this char is not in trie then add
			// else move to childeren of it
			if (curr.child[ch-'0'] == null)
				curr.child[ch - '0'] = new TrieNode();
			curr = curr.child[ch-'0'];
		}
	}

    public int longestPrefix(int num) {
		TrieNode curr = root;
        String str = Integer.toString(num);
        int result = 0;
		for (char ch : str.toCharArray()) {
			// if this char is not in trie then return false
			// else move to childeren of it
			if (curr.child[ch-'0'] == null)
				break;
            else
                result++;
			curr = curr.child[ch-'0'];
		}
        return result;
	}

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int ans = 0;
        for(int ele : arr1) 
            insert(ele);
        
        for(int ele : arr2) 
            ans = Math.max(ans, longestPrefix(ele));
        
        return ans;
    }
}