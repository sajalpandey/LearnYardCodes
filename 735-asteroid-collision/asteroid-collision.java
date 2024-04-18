class Solution {
    public int[] asteroidCollision(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++) {
            if(arr[i] < 0) {
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(arr[i]))
                    st.pop();
                if(!st.isEmpty() && st.peek()+arr[i] == 0) {
                    st.pop();
                    continue;
                }
                if(!st.isEmpty() && st.peek() < 0 || st.isEmpty())
                    st.push(arr[i]);
                // else if(st.isEmpty())
                //     st.push(arr[i]);
            } else {
                // while(!st.isEmpty() && st.peek() < 0 && Math.abs(st.peek()) < arr[i])
                //     st.pop();
                // if(!st.isEmpty() && st.peek()+arr[i] == 0) {
                //     st.pop();
                //     continue;
                // }
                // if(!st.isEmpty() && st.peek() > 0)
                //     st.push(arr[i]);
                // else if(st.isEmpty())
                st.push(arr[i]);
            }
        }
        int k = st.size();
        //System.out.println("k = "+k);
        int result[] = new int[k];
        for(int i=k-1; i>=0; i--) {
            result[i] = st.peek();
            st.pop();
        }
        return result;
    }
}