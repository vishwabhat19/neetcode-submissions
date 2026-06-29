class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();
       subsets(nums, result, 0, new ArrayList());
       return result; 
    }

    void subsets(int[] nums, List<List<Integer>> result, int current, List<Integer> tempList) {
        result.add(new ArrayList(tempList));

        for(int i=current;i<nums.length;i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;
            tempList.add(nums[i]);
            subsets(nums, result, i+1, tempList);
            tempList.remove(tempList.size() - 1);
        }
     }
}
