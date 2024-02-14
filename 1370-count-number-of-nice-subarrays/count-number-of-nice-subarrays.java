class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer,Integer> prefix = new HashMap<>();
        prefix.put(0,1);
        int count = 0, result = 0;
        for(int i=0; i<nums.length; i++) {
            nums[i] = nums[i]%2==0 ? 0 : 1;            
            count += nums[i];
            int rem = count - k;
            if(prefix.containsKey(rem)) {
                result += prefix.get(rem);
            }
            prefix.put(count,prefix.getOrDefault(count,0)+1);
        }
        return result;
    }
}