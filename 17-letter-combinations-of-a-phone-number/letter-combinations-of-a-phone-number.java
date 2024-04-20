class Solution {
    public static void helper(List<String> result, StringBuilder str, String digits,String [] letters, int index) {
        if(index > digits.length())
            return;
        if(str.length() == digits.length()) {
            result.add(str.toString());
            return;
        }
        String temp = letters[(digits.charAt(index))- 48];
        for(int i=0; i<temp.length(); i++) {
            str.append(temp.charAt(i));
            helper(result,str,digits,letters,index+1);
            str.deleteCharAt(str.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        /**
        n = 29
        2 = abc
        9 = wxyz
        (aw,ax,az,ay,bw,..........) =  24
         */
        List<String> result = new ArrayList<>();
        if(digits.length() == 0)
            return result;
        String [] letters = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder str = new StringBuilder();
        helper(result, str, digits, letters,0);
        return result;
    }
}