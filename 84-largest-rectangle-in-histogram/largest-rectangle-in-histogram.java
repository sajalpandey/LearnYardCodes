class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for(int i=0; i<heights.length; i++) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                int ele = st.peek();
                st.pop();
                int prevSmaller = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, (i- prevSmaller - 1)*heights[ele]);
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            int ele = heights[st.pop()];
            int prevSmaller = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, (heights.length- prevSmaller - 1)*ele);
        }
        return maxArea;
    }
}