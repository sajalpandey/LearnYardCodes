class Solution {
    public int[] decrypt(int[] code, int k) {
        int result[] =  new int[code.length];
        int sum = 0;
        int n = code.length;
        if(k==0)
            return result;
        else if(k > 0) {
            for(int i=0; i<code.length; i++) {
                sum = 0;
                for(int j=0; j<k; j++)
                    sum += code[(i+1+j)%n];
                result[i] = sum;
            }
        } else {
            for(int i=0; i<code.length; i++) {
                sum = 0;
                for(int j=0; j<Math.abs(k); j++) 
                    sum += code[(i-j-1+n)%n];
                result[i] = sum;
            }
        }
        return result;
    }
}