class Solution {
    public static void combinationSumHelper(List<List<Integer>> result, int[] candidates, List<Integer> temp, int i, int target) {
        if(target < 0)
            return;
        if(target == 0) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        if(i == candidates.length) {
            if(target == 0) 
                result.add(new ArrayList<Integer>(temp));
            return;
        }

        temp.add(candidates[i]);
        combinationSumHelper(result, candidates, temp, i, target-candidates[i]);

        //backtrack
        temp.remove(temp.size()-1);
        combinationSumHelper(result, candidates, temp, i+1, target);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combinationSumHelper(result, candidates, temp, 0, target);
        return result;
    }
}