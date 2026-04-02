class Solution {
    List<List<Integer>> resp;

    public List<List<Integer>> subsets(int[] nums) {
        resp = new ArrayList<>();

        helper(nums, 0, new ArrayList<Integer>());

        return resp;
    }

    private void helper(int[] nums, int i, List<Integer> curr) {
        if (i >= nums.length) {
            resp.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        helper(nums, i+1, curr);

        curr.remove(curr.size() - 1);
        helper(nums, i+1, curr);
    }
}
