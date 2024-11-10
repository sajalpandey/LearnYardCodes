class Solution {
    public void solveNQueensHelper(int row, int n, List<List<String>> result, List<String> board,
    boolean[] top, boolean[] topleft, boolean[] topright) {
        // we have placed n queens
        if(row == n) {
            result.add(new ArrayList<>(board));
            return;
        }

        //now we will try to place Queen in given row, try every where in column
        for(int i=0; i<n; i++) {
            //we can place a queen if all 3 array allows
            if(!top[i] && !topleft[row-i+n-1] && !topright[row+i]) {

                top[i] = true;
                topright[row+i] = true;
                topleft[row-i+n-1] = true;
                char[] temp = new char[n];
                Arrays.fill(temp, '.');
                temp[i] = 'Q';
                board.add(new String(temp));
                solveNQueensHelper(row+1, n, result, board, top, topleft, topright);

                top[i] = false;
                topright[row+i] = false;
                topleft[row-i+n-1] = false;
                board.remove(board.size()-1);
            }
        }
    } 
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> board = new ArrayList<>();
        boolean[] top = new boolean[n];
        boolean[] topleft = new boolean[2*n];
        boolean[] topright = new boolean[2*n];
        solveNQueensHelper(0, n, result, board, top, topleft, topright);
        return result;
    }
}