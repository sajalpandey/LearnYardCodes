class Solution {
    public boolean check(int[] hand, int groupSize, int i) {
        int ele = hand[i];
        hand[i++] = -1;
        int count = 1;
        while(i < hand.length && count < groupSize) {
            if(hand[i] == ele+1) {
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
            if(hand[i] >= 0)
                if(!check(hand, groupSize, i))
                    return false;
        }
        return true;
    }
}