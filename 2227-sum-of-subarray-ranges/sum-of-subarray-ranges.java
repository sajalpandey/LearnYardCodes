class Solution {
    public long subArrayRanges(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] nextSmaller = new int[n];
        int[] prevSmaller = new int[n];

        int[] nextGreater = new int[n];
        int[] prevGreater = new int[n];

        Arrays.fill(nextSmaller, n);
        Arrays.fill(prevSmaller, -1);
        Arrays.fill(nextGreater, n);
        Arrays.fill(prevGreater, -1);

        //Calculate next Smaller ele for each
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && nums[st.peek()] > nums[i])
                st.pop();
            if(!st.isEmpty())
                nextSmaller[i] = st.peek();
            st.push(i);
        }
        st.clear();

        //Calculate previous Smaller ele 
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i])
                st.pop();
            if(!st.isEmpty())
                prevSmaller[i] = st.peek();
            st.push(i);
        }
        st.clear();

        //Calculate next greater ele for each
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i])
                st.pop();
            if(!st.isEmpty())
                nextGreater[i] = st.peek();
            st.push(i);
        }
        st.clear();

        //Calculate previous greater ele for each
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && nums[st.peek()] <= nums[i])
                st.pop();
            if(!st.isEmpty())
                prevGreater[i] = st.peek();
            st.push(i);
        }
        st.clear();

        long result = 0;
        for(int i=0; i<n; i++) {
            //How many subarrays this ele will contribute as SMALLER element and find sum
            // no of subarrays * ele = total sum(serving as minimum ele)
            long m = i - prevSmaller[i];
            long r = nextSmaller[i] - i;

            //How many subarrays this ele will contribute as GREATER element and find sum
            // no of subarrays * ele = total sum(serving as maximum ele)
            long p = i - prevGreater[i];
            long q = nextGreater[i] - i;

            result += (p*q - m*r) * nums[i];
        }
        return result;
    }
}