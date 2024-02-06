class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int oIdx1 = 0, oIdx2 = 0;
        int inX=0, inY=0;
        while(oIdx1<word1.length && oIdx2<word2.length) {
            if(word1[oIdx1].charAt(inX)!=word2[oIdx2].charAt(inY))
                return false;
            if(inX < word1[oIdx1].length())
                inX++;
            if(inY < word2[oIdx2].length())
                inY++;
            if(inX == word1[oIdx1].length()){
                inX = 0;
                oIdx1++;
            }
            if(inY == word2[oIdx2].length()){
                inY = 0;
                oIdx2++;
            }
        }
        if(oIdx1 == word1.length && oIdx2 ==word2.length)
            return true;
        return false;
    }
}