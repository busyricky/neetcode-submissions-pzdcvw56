class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> resp = new ArrayList<>();

        helper(nums, 0, resp, new ArrayList<>());

        return resp;
    }

    private void helper(int[] nums, int idx, List<List<Integer>> resp, List<Integer> subset) {
        if (idx >= nums.length) {
            resp.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[idx]);
        helper(nums, idx+1, resp, subset);

        subset.remove(subset.size() - 1);
        while (idx+1 < nums.length && nums[idx] == nums[idx+1]) {
            idx++;
        }
        helper(nums, idx+1, resp, subset);
    }
}
