class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int [] result = new int[nums.length];
        for(int i=nums.length-1; i>=0; i--)
            st.push(nums[i]);
        
        for(int i=nums.length-1; i>=0; i--) {
            result[i] = -1;
            while(!st.empty() && nums[i]>=st.peek())
                st.pop();
            if(!st.empty())
                result[i] =  st.peek();
            st.push(nums[i]);
        }
        return result;
    }
}