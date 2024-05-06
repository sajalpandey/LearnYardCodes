class Solution {
    public long mostPointsHelper(int[][] questions, int i) {
        if(i >= questions.length)
            return 0;
        //Two choice
        //1. Take this question
        long maxPoints1 = questions[i][0] + mostPointsHelper(questions, (1 + i + questions[i][1]));

        //2. Skip it
        long maxPoints2 = 0 + mostPointsHelper(questions, (1 + i));

        return Math.max(maxPoints1, maxPoints2);
    }

    public long mostPointsTopDown(int[][] questions, int i, long[] dp) {
        if(i >= questions.length)
            return 0;

        if(dp[i] != -1)
            return dp[i];
        //Two choice
        //1. Take this question
        long maxPoints1 = questions[i][0] + mostPointsTopDown(questions, (1 + i + questions[i][1]), dp);

        //2. Skip it
        long maxPoints2 = 0 + mostPointsTopDown(questions, (1 + i), dp);

        return dp[i] = Math.max(maxPoints1, maxPoints2);
    }
    public long mostPoints(int[][] questions) {
        //1. Recursion
        //return mostPointsHelper(questions, 0);

        //2. DP Top Down
        long[] dp = new long[questions.length+1];
        Arrays.fill(dp, -1);
        return mostPointsTopDown(questions, 0, dp);
    }
}