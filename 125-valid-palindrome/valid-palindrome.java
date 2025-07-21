class Solution {
    public boolean isPalindrome(String s) {
        if(s == null)
            return true;
        char[] arr = s.trim().toLowerCase().toCharArray();
        int i=0, j = arr.length-1;
        while(i < j) {
            while(i < j && !Character.isLetterOrDigit(arr[i]))
                i++;
            while(i<j && !Character.isLetterOrDigit(arr[j]))
                j--;
            if(arr[i] != arr[j])
                return false;
            
            i++;
            j--;
        }
        return true;
    }
}