class Solution {
    List<List<Integer> > adj;
    int n, maxScoreCnt;
    long maxScore;
    int[] sub;

    void dfs(int cur, int par) {
        long curScore = 1;
        sub[cur] = 1;
        for(int i = 0; i < adj.get(cur).size(); ++i) {
            int nb = adj.get(cur).get(i);
            if(nb == par)
                continue;
            dfs(nb, cur);
            sub[cur] += sub[nb]; // calculating the sub[cur] appropriately
            curScore *= sub[nb];
        }
        if(cur != 0) {
            curScore *= (n - sub[cur]);
        }
        
        // curScore > maxScore
        if(curScore > maxScore) {
            maxScore = curScore;
            maxScoreCnt = 1;
        }
        else if(curScore == maxScore) { // curScore == maxScore
            maxScoreCnt += 1;
        }
    }
    public int countHighestScoreNodes(int[] parents) {
        adj = new ArrayList<>();
        n = parents.length;
        sub = new int[n];
        for(int i = 0; i < n; ++i)
            adj.add(new ArrayList<>());
        
        //make adjacency list from parents array

        for(int i = 0; i < n; ++i) {
            int j = parents[i];
            if(j == -1)
                continue;
            adj.get(i).add(j);
            adj.get(j).add(i);
        }

        //now DFS to find subarray
        dfs(0, -1);

        return maxScoreCnt;
        
    }
}