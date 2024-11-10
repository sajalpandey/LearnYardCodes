class Solution {
    public boolean isPalindrome(String str, int i, int j) {
        while(i < j) {
            if(str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public void partitionHelper(String s, int index, List<String> temp, List<List<String>> result) {
        if(index == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        //now we will start partition from every index 
        //if the partition is palindrome then will move forward
        for(int i=index; i<s.length(); i++) {
            if(isPalindrome(s, index, i)) {
                temp.add(s.substring(index, i+1));
                partitionHelper(s, i+1, temp, result);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        partitionHelper(s, 0, temp, result);
        return result;
    }
}