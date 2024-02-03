class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        StringBuilder result =  new StringBuilder();
        int carry = 0;
        while(i>=0 && j>=0) {
            if(a.charAt(i)=='1' && b.charAt(j)=='1') {
                //System.out.println("CASE 1");
                if(carry==1) 
                    result.append(1);
                else 
                    result.append(0);
                carry = 1;
            } else if(a.charAt(i)=='1'){
                //System.out.println("CASE 2");
                if(carry==1) {
                    result.append(0);
                    carry = 1;
                } else {
                    result.append(1);
                    carry = 0;
                }
            } else if(b.charAt(j)=='1'){
                //System.out.println("CASE 3");
                if(carry==1) {
                    result.append(0);
                    carry = 1;
                } else {
                    result.append(1);
                    carry = 0;
                }
            } else {
                if(carry==1) {
                    result.append(1);
                    carry = 0;
                } else {
                    result.append(0);
                    carry = 0;
                }
            }
            i--;
            j--;
            //System.out.println("result = "+result);
        }
        System.out.println("result = "+result);
        while(i>=0) {
            if(a.charAt(i)=='1'){
                if(carry==1){
                    result.append(0);
                    carry = 1;
                } else {
                    result.append(1);
                }
            } else {
                if(carry==1) {
                    result.append(1);
                    carry = 0;
                } else {
                    result.append(0);
                }
            }
            //System.out.println("result = "+result);
            i--;
        }
        while(j>=0) {
            //System.out.println("j = "+j);
            if(b.charAt(j)=='1'){
                if(carry==1){
                    result.append(0);
                    carry = 1;
                } else {
                    result.append(1);
                }
            } else {
                if(carry==1) {
                    result.append(1);
                    carry = 0;
                } else {
                    result.append(0);
                }
            }
            j--;
        }
        if(carry==1)
            result.append(1);
        
        return result.reverse().toString();
    }
}