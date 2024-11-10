class Solution {
    public void combinationSum2Helper(int[] candidates, int index, List<Integer> temp,
    int target, List<List<Integer>> result) {
        //base case
        if(target < 0 || index > candidates.length)
            return;
        // if target becomes 0
        if(target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index; i<candidates.length; i++) {
            //avoid duplicates
            if(i > index && candidates[i] == candidates[i-1])
                continue;
            temp.add(candidates[i]);
            combinationSum2Helper(candidates, i+1, temp, target-candidates[i], result);
            temp.remove(temp.size()-1);
            //combinationSum2Helper(candidates, i+1, temp, target, result);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combinationSum2Helper(candidates, 0, new ArrayList<>(), target, result);
        return result;
    }
}