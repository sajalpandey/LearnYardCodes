class Solution {
    public int [] prevSmallerEle(int[] heights) {
        int [] prevSmaller = new int[heights.length];
        Stack<Integer> st = new Stack<>();
        //st.push(-1);
        for(int i=0; i<heights.length; ++i) {
            while(!st.empty() && heights[st.peek()] >= heights[i])
                st.pop();
            prevSmaller[i] = st.empty() == true ? -1 : st.peek();
            st.push(i);
        }
        return prevSmaller;
    }

    public int [] nextSmallerEle(int[] heights) {
        int [] nextSmaller = new int[heights.length];
        Stack<Integer> st = new Stack<>();
        //st.push(heights.length);
        for(int i=heights.length-1; i>=0; --i) {
            while(!st.empty() && heights[st.peek()] >= heights[i])
                st.pop();
            nextSmaller[i] = st.empty() == true ? heights.length : st.peek();
            st.push(i);
        }
        return nextSmaller;
    }

    public int largestRectangleArea(int[] heights) {
        //First find index of first smaller ele on left side
        // find index for first smaller ele on right side
        // now the area for that index will be height[j] * (r-l-1);
        int n = heights.length;
        int prevSmaller [] = new int[n];
        int nextSmaller [] = new int[n];

        prevSmaller = prevSmallerEle(heights);
        nextSmaller = nextSmallerEle(heights);
        int result = Integer.MIN_VALUE;
        for(int i=0; i<n; ++i) {
            result = Math.max(result, heights[i] * (nextSmaller[i] - prevSmaller[i] - 1));
        }
        return result;
    }
}