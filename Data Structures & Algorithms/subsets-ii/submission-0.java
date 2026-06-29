class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        subsetsWithDup(nums, result, new ArrayList(), 0);
        return result;
    }

    void subsetsWithDup(int[] nums, List<List<Integer>> result, List<Integer> tempList, int currentIndex) {
        result.add(new ArrayList(tempList));

        for(int i=currentIndex;i<nums.length;i++) {
            if (i > currentIndex && nums[i] == nums[i-1]) continue;
            tempList.add(nums[i]);
            subsetsWithDup(nums, result, tempList, i+1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
