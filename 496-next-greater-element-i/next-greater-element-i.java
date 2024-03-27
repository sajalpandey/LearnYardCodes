class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int [] result = new int [nums1.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=nums2.length-1; i>=0; i--){
            while(!st.empty() && st.peek() < nums2[i])
                st.pop();
            map.put(nums2[i],(st.empty() ? -1 : st.peek()));
            st.push(nums2[i]);
        }
        for(int i=0; i<nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}