class TrieNode {
    TrieNode[] child = new TrieNode[2];
}

class Solution {
    TrieNode root = new TrieNode();
    public int findMaximumXOR(int[] nums) {
        int result = Integer.MIN_VALUE;
        
        for(int num : nums) {
            //iterate over every element
            TrieNode curr = root;
            for(int i=31; i>=0; i--) {
                //now iterate over every bit of num check if its set or not
                int bit = (num >>> i) & 1;
                if(curr.child[bit] == null)
                    curr.child[bit] = new TrieNode();
                curr = curr.child[bit];
            }
        }

        for(int num :  nums) {
            TrieNode curr = root;
            int sum = 0;
            for(int i=31; i>=0; i--) {
                int currBit = (num >>> i) & 1;
                int flippedBit = currBit ^ 1;
                if(curr.child[flippedBit] != null) {
                    curr = curr.child[flippedBit];
                    sum += (1 << i);
                } else {
                    curr = curr.child[currBit];
                }
            }
            result = Math.max(result, sum);
        }
        return result;
    }
}