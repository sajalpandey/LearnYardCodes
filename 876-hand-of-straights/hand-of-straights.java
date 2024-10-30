class Solution {
    public boolean checkGroupPossible(int[] hand, int i, int groupSize) {
        int ele = hand[i];
        hand[i] = -1;
        i++;
        int count = 1;
        while(i < hand.length && count < groupSize) {
            if((1 + ele) == hand[i]) {
                ele = hand[i];
                hand[i] = -1;
                count++;
            }
            i++;
        }

        if(count == groupSize)
            return true;
        return false;

    }
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0)
            return false;
        
        Arrays.sort(hand);
        for(int i=0; i<n; i++) {
            if(hand[i] >= 0) {
                if(!checkGroupPossible(hand, i, groupSize)) 
                    return false;
            }
        }
        return true;
    }
}