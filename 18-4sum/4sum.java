class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int p=0; p<n; p++) {
            for(int i=p+1; i<n; i++) {
                int j = i+1, k = n-1;
                while(j < k) {
                    double sum = (double)nums[p] + (double)nums[i] + (double)nums[j] + (double)nums[k];
                    if(sum == target) {
                        result.add(Arrays.asList(nums[p], nums[i], nums[j], nums[k]));
                        while(j+1 < k && nums[j] == nums[j+1])
                            j++;
                        while(k-1 > j && nums[k] == nums[k-1])
                            k--;
                        j++;k--;
                    }
                    else if(sum < target)
                        j++;
                    else 
                        k--;
                }
                while(i+1 < n && nums[i] == nums[i+1])
                    i++;
            }
            while(p+1 < n && nums[p] == nums[p+1])
                p++;
        }
        
        return result;
    }
}