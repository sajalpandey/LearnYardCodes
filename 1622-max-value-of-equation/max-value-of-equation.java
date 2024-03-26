class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int result = Integer.MIN_VALUE;
        Deque<Integer> dq = new LinkedList<>();
        for(int i=0; i<points.length; ++i) {

            // First check if deque contains max coordinate of within the range
            // like give xj - xi <= k
            //yi + yj + |xi - xj|
            // yi + yj + xj - xi ==> yj + xj + (yi - xi)
            while(!dq.isEmpty() && points[i][0] - points[dq.peekFirst()][0] > k)
                dq.removeFirst();
            
            if(!dq.isEmpty()) {
                int j = dq.peekFirst();
                int ans = points[i][1] + points[i][0] + (points[j][1] - points[j][0]);
                result = Math.max(result, ans); 
            }

            // Insert this point to maintains that maximum yi - xi should be maximum
            // in deque front
            int value = points[i][1] - points[i][0];
            while(!dq.isEmpty() && (points[dq.peekLast()][1] - points[dq.peekLast()][0]) <= value)
                dq.removeLast();
            dq.addLast(i);
        }
        return result;
    }
}