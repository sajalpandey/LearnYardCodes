class Solution {
    public int sumSubarrayMins(int[] arr) {
        int sum = 0;
        int n = arr.length;
        int mod = 1000000007;
        Stack<Integer> st = new Stack<>();
        int left[] = new int[n];
        int right[] = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            left[i] = st.empty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();
        for(int i=n-1; i>=0; i--) {
            while(!st.empty() && arr[st.peek()] > arr[i])
                st.pop();
            right[i] = st.empty() ? n : st.peek();
            st.push(i);
        }

        for(int i=0; i<n; i++) {
            long count = (long) (i - left[i]) * (right[i] - i) % mod;
            sum = (int) ((sum + count * arr[i]) % mod);
        }
        return sum;
    }
}