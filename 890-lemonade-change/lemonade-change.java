class Solution {
    public boolean lemonadeChange(int[] bills) {
        int [] coins = new int [21];
        for(int i=0; i<bills.length; i++) {
            int rem = bills[i] - 5;
            //System.out.println("bill--> "+bills[i]+" rem = "+rem+" -5Rs: "+coins[5]+" -10Rs: "+coins[10]+" -20Rs: "+coins[20]);
            coins[bills[i]]++;

            if(rem == 0)
                continue;
            //if(rem >= 20) {
                while(rem -20 >= 0 && coins[20] > 0) {
                    rem -= 20;
                    coins[20]--;
                }
            //}
           
            //if(rem >= 10) {
                while(rem -10 >= 0 && coins[10] > 0) {
                    rem -= 10;
                    coins[10]--;
                }
            //}

            //if(rem >= 5) {
                while(rem -5 >= 0 && coins[5] > 0) {
                    rem -= 5;
                    coins[5]--;
                }
            //}

            if(rem!=0)
                return false;
        }
        return true;
    }
}