class Solution {
    public boolean isCharacter(char ch) {
        return ch >= 'a' && ch <= 'z' || ch >= '0' && ch <='9';
    }
    public boolean isPalindrome(String s) {
        char[] arr = s.toLowerCase().toCharArray();;
        int i=0, j = arr.length-1;
        while(i <= j) {
            System.out.println(arr[i]+" -- "+arr[j]);
            if(isCharacter(arr[i]) && isCharacter(arr[j])) {
                if(arr[i] != arr[j])
                    return false;
                i++; j--;
            } else if(!isCharacter(arr[i]))
                i++;
            else if(!isCharacter(arr[j]))
                j--;
        }
        return true;
    }
}