class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for(int ele : bills) {
            if(ele == 5)
                five++;
            else if(ele == 10)
                ten++;
            int rem = ele - 5;
            if(rem == 0)
                continue;
            else if(rem == 5 && five > 0)
                five--;
            else if(rem == 15) {
                if(ten > 0) {
                    ten--;
                    rem -= 10;
                }
                if(rem == 5 && five > 0)
                    five--;
                else if(rem == 15 && five >= 3)
                    five -= 3;
                else
                    return false;
            } else
                return false;
        }
        return true;
    }
}