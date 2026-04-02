class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> resp = new ArrayList<>();

        helper(resp, nums, target, 0, new ArrayList<>(), 0);

        return resp;
    }

    private void helper(List<List<Integer>> resp, int[] nums, int target, int i, List<Integer> currList, int currSum) {
        if (currSum == target) {
            resp.add(currList);
            return;
        } else if (currSum > target) {
            return;
        } else if (i >= nums.length) {
            return;
        }

        List<Integer> listCopy = new ArrayList<>(currList);
        listCopy.add(nums[i]);
        helper(resp, nums, target, i, listCopy, currSum + nums[i]);

        helper(resp, nums, target, i + 1, currList, currSum);
    }
}
