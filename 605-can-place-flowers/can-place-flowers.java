class Solution {
    public boolean canPlaced(int[] fl, int index, int lastPlaced) {
        int n = fl.length;
        if(index == 0) {
            if(n == 1)
                return true;
            if(index+1 < n && fl[index+1] == 0)
                return true;
        } else if(index == n-1 && lastPlaced < index - 1){
                return true;
        } else {
            if(lastPlaced < index - 1 && index+1 < n && fl[index+1] == 0)
                return true;
        } 
        return false;
    }
    public boolean canPlaceFlowers(int[] fl, int n) {
        if(n==0)
            return true;
        int lastPlaced = -1;
        for(int i=0; i<fl.length; i++) {
            if(fl[i] == 0) {
                if(canPlaced(fl,i,lastPlaced)) {
                    lastPlaced = i;
                    n--;
                    if(n==0)
                        return true;
                }
            } else
                lastPlaced = i;
        }
        return (n==0);
    }
}