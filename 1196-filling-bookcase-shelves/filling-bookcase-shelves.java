class Solution {
    int origW;
    public int minHeightShelvesHelper(int[][] books, int currShelfWidth, int i, int currentH) {

        if(i >= books.length)
            return currentH;
        /**
        We have two options , either to take this book in current shelf
        Or place it in next shelf
         */
        
        int takeIt = Integer.MAX_VALUE;
        if(books[i][0] <= currShelfWidth)
            takeIt = minHeightShelvesHelper(books, currShelfWidth-books[i][0], i+1, Math.max(currentH, books[i][1]));
        int skipIt = currentH + minHeightShelvesHelper(books, origW-books[i][0], i+1, books[i][1]);

        return Math.min(takeIt, skipIt);
    }

    public int minHeightShelvesDP(int[][] books, int currShelfWidth, int i, int currentH, int[][]dp) {

        if(i >= books.length)
            return currentH;
        if(dp[i][currShelfWidth] != -1)
            return dp[i][currShelfWidth];
        /**
        We have two options , either to take this book in current shelf
        Or place it in next shelf
         */
        
        int takeIt = Integer.MAX_VALUE;
        if(books[i][0] <= currShelfWidth)
            takeIt = minHeightShelvesDP(books, currShelfWidth-books[i][0], i+1, Math.max(currentH, books[i][1]), dp);
        int skipIt = currentH + minHeightShelvesDP(books, origW-books[i][0], i+1, books[i][1], dp);

        return dp[i][currShelfWidth] = Math.min(takeIt, skipIt);
    }
    public int minHeightShelves(int[][] books, int shelfWidth) {
        origW = shelfWidth;
        //return minHeightShelvesHelper(books, shelfWidth, 0, 0);

        //DP Solution
        int n = books.length;
        int[][]dp = new int[n+1][shelfWidth+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return minHeightShelvesDP(books, shelfWidth, 0, 0, dp);
    }
}