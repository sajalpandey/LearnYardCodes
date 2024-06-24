class Solution {
    List<List<Integer>> adj;
    int[] vis;
    int[][] mark;
    public void topoBfs(int numCourses) {
        int[] indegree = new int[numCourses];
        Arrays.fill(indegree, 0);
        
        //update indegree of each node
        for(int i=0; i<numCourses; i++) {
            for(int nb : adj.get(i))
                indegree[nb]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        //psuh nodes with indegree as "0"
        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0)
                q.add(i);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        while(!q.isEmpty()) {
            int front = q.poll();
            list.add(front);
            
            //Visit all its neighbour, and decrement its indegree
            for(int nb : adj.get(front)) {
                mark[front][nb] = 1;
                for(int i=0; i<numCourses; i++) {
                    if(mark[i][front] == 1)
                        mark[i][nb] = 1;
                }   
                indegree[nb]--;
                //if indegree becomes 0 add this node in queue      
                if(indegree[nb] == 0)
                    q.add(nb);
            }
        };
        
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            //System.out.print(list.get(i)+" ");
            result[i] = list.get(i);
        }
        //return result;
    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] pre, int[][] queries) {
        adj = new ArrayList<>();
        vis = new int[numCourses];
        mark = new int[numCourses][numCourses];
        for(int i=0; i<numCourses; i++)
            adj.add(new ArrayList<>());
        
        //create adjacency list
        for(int i=0; i<pre.length; i++) {
            int p = pre[i][0];
            int qq = pre[i][1];
            //add an directed edge from p --> q
            mark[p][qq] = 1;
            adj.get(p).add(qq);
        }

        topoBfs(numCourses);

        List<Boolean> result = new ArrayList<>();
        if(pre.length == 0) {
            for(int i=0; i<queries.length; i++)
                result.add(false);
            return result;
        }
        for(int i=0; i<queries.length; i++) {
            if(mark[queries[i][0]][queries[i][1]] == 1)
                result.add(true);
            else
                result.add(false);
        }

        return result;
    }
}