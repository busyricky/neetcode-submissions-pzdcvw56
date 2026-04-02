class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resp = new ArrayList<>();

        dfs(nums, resp, 0);

        return resp;
    }

    private void dfs(int[] nums, List<List<Integer>> resp, int idx) {
        if (idx >= nums.length) {
            List<Integer> respList = new ArrayList<>();
            for (int num : nums) {
                respList.add(num);
            }
            resp.add(respList);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            int tmp = nums[idx];
            nums[idx] = nums[i];
            nums[i] = tmp;

            dfs(nums, resp, idx+1);

            tmp = nums[idx];
            nums[idx] = nums[i];
            nums[i] = tmp;
        }
    }
}
