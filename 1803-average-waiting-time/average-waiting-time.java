class Solution {
    public double averageWaitingTime(int[][] customers) {
        long result = 0;
        int time = customers[0][0];
        long totalTime = time + customers[0][1];
        result += (totalTime - time);
        for(int i=1; i<customers.length; i++) {
            // add waiting period
            //System.out.println("time = "+time+" -- totalTime = "+totalTime);
            time = customers[i][0];
            if(time > totalTime) {
                //time to reset value;
                totalTime = time + customers[i][1];
            } else
                totalTime += customers[i][1];
            //System.out.println("time = "+time+" -- totalTime = "+totalTime);
            result += (totalTime - time);   
        }
        return (result*1.0/customers.length*1.0);
    }
}