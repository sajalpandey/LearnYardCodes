class Solution {
    public static boolean isValid(char[][] board, int row, int col, int num) {
        for(int i=0; i<9; i++) {
            //check in that row if the number is present 
            if(board[row][i] == num) 
                return false;

            //check in that column if the number is present 
            if(board[i][col] == num)
                return false;

            //check in that sub-matrix if the number is present 
            if(board[3 * (row/3) + (i/3)][3 * (col/3) + (i%3)] == num)
                return false;
        }
        return true;
    }
    public static boolean solveSudokuHelper(char[][] board) {
        //Iterate over row and column
        //find an empty slot where we need to put number
        //Now in that empty slot we will try to fill numbers from 1 .... to 9
        //If possible to place that number this means we can continue filling other empty slots
        //Now call recursion to fill others slots
        //If above recursion call return true means we filled the sudoku in a right way
        //if above recursion call retruns FALSE this means filled number at that position is not working for us
        //Now BACKTRACK and revert the changes , , try out other number
        //If none of the filled numbers return true means we can not fill number and return FALSE from here
        //If you are not find any empty slots this means we can return true

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                //Found an empty slot
                if(board[i][j] == '.') {
                    //Iterate over numbers from 1 to 9 and try to fill
                    for(char num='1'; num<='9'; num++) {
                        if(isValid(board,i,j,num)) {
                            board[i][j] = num;
                                if(solveSudokuHelper(board) == true)
                                    return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }
}