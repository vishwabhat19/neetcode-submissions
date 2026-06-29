class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, result, new ArrayList(), 0);
        return result;
    }

    void combinationSum(int[] candidates, int remaining, List<List<Integer>> result, 
    List<Integer> tempList, int currentIndex) {
        if (remaining == 0) {
            result.add(new ArrayList(tempList));
            return;
        }

        if (remaining < 0) return;

        for(int i=currentIndex;i<candidates.length;i++) {
            if (i > currentIndex && candidates[i] == candidates[i-1]) continue;
            tempList.add(candidates[i]);
            combinationSum(candidates, remaining - candidates[i], result, tempList, i+1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
