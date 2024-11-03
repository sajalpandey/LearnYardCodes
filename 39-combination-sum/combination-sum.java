class Solution {
    public void combinationSumHelper(int i, int[] candidates, int target,
    List<List<Integer>> result, List<Integer> temp) {
        if(target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if(i >= candidates.length || target < 0) {
            return;
        }
        temp.add(candidates[i]);
        combinationSumHelper(i, candidates, target-candidates[i], result, temp);
        temp.remove(temp.size()-1);
        combinationSumHelper(i+1, candidates, target, result, temp);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combinationSumHelper(0, candidates, target, result, temp);
        return result;
    }
}