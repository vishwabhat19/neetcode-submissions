class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        boolean visited[] = new boolean[nums.length];
        permute(nums, result, new ArrayList(), visited);
        return result;
    }

    void permute(int[] nums, List<List<Integer>> result, List<Integer> tempList, boolean visited[]) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList(tempList));
            return;
        }

        for(int i=0;i<nums.length;i++) {
            if (visited[i]) continue;
            visited[i] = true;
            tempList.add(nums[i]);
            permute(nums, result, tempList, visited);
            tempList.remove(tempList.size() - 1);
            visited[i] = false;
        }
    }

}
