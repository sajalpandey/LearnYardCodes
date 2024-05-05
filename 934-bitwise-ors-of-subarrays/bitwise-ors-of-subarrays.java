class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> curr, prev = new HashSet<>(), result = new HashSet<>();

        for(int ele : arr) {
            curr = new HashSet<>();
            prev.add(0);
            for(int p : prev) {
                curr.add(p|ele);
                result.add(p|ele);
            }
            prev = curr;
            curr = null;
        }
        return result.size();
    }
}