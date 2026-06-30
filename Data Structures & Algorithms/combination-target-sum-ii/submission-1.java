class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList();
        sum(result, candidates, target, 0, new ArrayList());
        return result;
    }

    void sum(List<List<Integer>> result, int[] candidates, int remaining, int currentIndex, List<Integer> tempList) {
        if (remaining == 0) {
            result.add(new ArrayList(tempList));
            return;
        }

        if (remaining < 0) return;

        for(int i=currentIndex;i<candidates.length;i++) {
            if (i!=currentIndex && candidates[i]==candidates[i-1]) continue;

            tempList.add(candidates[i]);
            sum(result, candidates, remaining-candidates[i], i+1, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
}
