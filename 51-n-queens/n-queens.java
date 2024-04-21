class Solution {
    public static void solveNQueensHelper(List<List<String>> result,List<String> board,int row,boolean[] top, boolean[] topLeft,boolean[] topRight, int n) {
        if(row == n) {
            result.add(new ArrayList<String>(board));
            return;
        }
        //iterate over every col for given ROW , try to place queen
        for(int j=0; j<n; ++j) {
            if(!top[j] && !topLeft[row-j+n-1] && !topRight[row+j]) {
                top[j] = true;
                topLeft[row-j+n-1] = true;
                topRight[row+j] = true;
                char[] r = new char[n];
                Arrays.fill(r,'.');
                r[j] = 'Q';
                board.add(new String(r));
                // Placed a queen in jth column of row and as recursion to place queens in next row
                solveNQueensHelper(result, board, row+1, top, topLeft, topRight, n);

                // Now backtrack to find another combination
                board.remove(board.size()-1);
                top[j] = false;
                topLeft[row-j+n-1] = false;
                topRight[row+j] = false;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> board = new ArrayList<>();
        boolean[] top = new boolean[n];
        boolean[] topLeft = new boolean[2*n];
        boolean[] topRight = new boolean[2*n];

        solveNQueensHelper(result,board,0,top,topLeft,topRight,n);
        return result;
    }
}