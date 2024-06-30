class Solution {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        else if(n == 2)
            return "11";
        StringBuilder num = new StringBuilder("1");
        while(--n > 0) {
            StringBuilder temp = new StringBuilder();
            for(int i=0; i<num.length(); i++) {
                int count = 1;
                char ch = num.charAt(i);
                while(i+1 < num.length() && num.charAt(i) == num.charAt(i+1)) {
                    count++;
                    i++;
                }
                temp.append(count);
                temp.append(ch);
            }
            num = temp;
        }
        return num.toString();
    }
}