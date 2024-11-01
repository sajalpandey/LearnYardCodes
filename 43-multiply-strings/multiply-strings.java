class Solution {
    public static String helper(String num1, char digit) {
        if (digit == '0')
            return "0";

        int carry = 0;
        StringBuilder product = new StringBuilder();
        int numDigit = digit - '0'; 

        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0'; 
            int currentProduct = n1 * numDigit + carry;
            product.append(currentProduct % 10); 
            carry = currentProduct / 10;
        }

        while (carry > 0) {
            product.append(carry % 10);
            carry /= 10;
        }

        return product.reverse().toString(); 
    }

    public static String SumofNum(String num1, String num2) {
        StringBuilder sum = new StringBuilder();
        int carry = 0;

        int i = num1.length() - 1, j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int n1 = (i >= 0) ? num1.charAt(i) - '0' : 0; 
            int n2 = (j >= 0) ? num2.charAt(j) - '0' : 0; 
            int currentSum = n1 + n2 + carry;
            sum.append(currentSum % 10);
            carry = currentSum / 10; 

            i--;
            j--;
        }
        return sum.reverse().toString(); 
    }

    public String multiply(String num1, String num2) {
        if (num1.length() < num2.length())
            return multiply(num2, num1);
        /**
         * 123
         * 456
         * -----------
         * 738
         * 6150
         * 49200
         * 
         */
        String result = "";
        for (int i = num2.length() - 1; i >= 0; i--) {
            String temp = helper(num1, num2.charAt(i));
            int n = num2.length() - i - 1;
            while (n-- > 0) {
                temp += '0';
            }
            result = SumofNum(result, temp);
        }
        return result;
    }
}