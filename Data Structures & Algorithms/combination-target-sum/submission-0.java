class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(nums, target, result, 0, new ArrayList());
        return result;
    }

    void combinationSum(int[] nums, int remaining, List<List<Integer>> result, int current, List<Integer> tempList) {
        if (remaining == 0) {
            result.add(new ArrayList(tempList));
            return;
        }

        if (remaining < 0) {
            return;
        }

        for(int i=current;i<nums.length;i++) {
            tempList.add(nums[i]);
            combinationSum(nums, remaining - nums[i], result, i, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
}
