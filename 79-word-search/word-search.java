class Solution {
    public static boolean findWord(char[][] board, int i, int j, String word, int index) {
        if(index == word.length()) {
            return true;
        }
            
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j]!=word.charAt(index))
            return false;
        
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean flag = findWord(board,i,j-1,word,index+1) 
                        || findWord(board,i,j+1,word,index+1) 
                        || findWord(board,i-1,j,word,index+1) 
                        || findWord(board,i+1,j,word,index+1);
        board[i][j] = temp;
        return flag;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == word.charAt(0) && findWord(board,i,j,word,0)) {
                    return true;
                }
            }
        }
        return false;
    }
    /***
    Word = "F CS"
     */
}