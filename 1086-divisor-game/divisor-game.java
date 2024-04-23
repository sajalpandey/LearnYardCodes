class Solution {
    public boolean divisorGameHelper(int n) {
        if(n == 1)
            return false;
        
        for(int i=1; i<n; i++) {
            if(n%i == 0) {
                boolean flag = divisorGameHelper(n-i);
                return flag == false ? true : false;
            }
        }
        return false;
    }
    public boolean divisorGame(int n) {
        return divisorGameHelper(n);
        //return true;
        // n = 3 (false)
        // choose num 1 to 2
        // Alice choses 1
        // new n = 3-1 = 2
        // 1 to 1
        // bob chose 1
        // new n = 2-1 = 1
        // Alice false

        // repetative work + optimal substructure (problem can be broken down to smaller problems)

        // n = 4 --> true
        // Alice choses from 1 to 3
        // 1
        // new n = 3
        // Bob 1
        // new n = 2
        // alice 1
        // new n = 1

        // n = 4 (false)
        // Alice chose 2
        // new n = 2
        // Bob 1
        // new n = 1

        // n = 5 (false)
        // Alice 1
        // new n = 4
        // Bob n 1
        // new n = 3
        // Alice 1
        // new n = 2
        // Bob 1
        // new n = 1

        // n = 5 (true)
        // Alice 1
        // new n = 4
        // Bob 2
        // new n = 2
        // Alice 1
        // new n = 1

        // n = 6 (true)
        // Alice 1
        // new n = 5
        // Bob 1
        // new n = 4
        // Alice 1
        // new n = 3
        // Bob 1
        // new n = 2
        // Alice 1
        // new n = 1

    }
}