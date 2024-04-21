class Solution {
    public static void combinationSum2Helper(List<List<Integer>> result, int[] candidates, List<Integer> temp, int i, int target) {
        if(target == 0) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        if(target < 0 || i >= candidates.length)
            return;

        temp.add(candidates[i]);
        combinationSum2Helper(result, candidates, temp, i+1, target-candidates[i]);
        //backtrack
        temp.remove(temp.size()-1);
        // Skip duplicates
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        combinationSum2Helper(result, candidates, temp, i+1, target);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        //System.out.println(Arrays.toString(candidates));
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combinationSum2Helper(result, candidates, temp, 0, target);
        return result;
    }
}