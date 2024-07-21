class Solution {
    public int[][] generateMatrix(int n) {
        int top = 0,rt = n-1,btm = n-1,lft= 0;
        ArrayList<Integer> result =  new ArrayList<>();
        int count = 1;
        int[][] ans = new int[n][n];
        while(top<=btm && lft <= rt) {
            if(top==btm && btm==rt && rt==lft)
                ans[top][top] = (count++);
            //print top row
            for(int i=lft; i<rt; i++)
                ans[top][i] = (count++);

            //print right column
            for(int i=top; i<btm; i++)
                ans[i][rt] = (count++);
            
            //System.out.println("rt = "+rt+"  -- lft = "+lft+"  -- btm = "+btm);
            //print bottom row
            for(int i=rt; i>lft; i--) {
                //System.out.println("Sajal : "+matrix[btm][i]);
                ans[btm][i] = (count++);
            }
                
            
            //print left row
            for(int i=btm; i>top; i--) {
                //System.out.println("sajal");
                ans[i][lft] = (count++);
            }
            top++;
            btm--;
            lft++;
            rt--;
        }
        return ans;
    }
}