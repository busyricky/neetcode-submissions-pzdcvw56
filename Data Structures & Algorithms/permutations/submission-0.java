class Solution {
    List<List<Integer>> resp;

    public List<List<Integer>> permute(int[] nums) {
        resp = new ArrayList<>();

        List<Integer> remaining = new ArrayList<>();
        for (int num : nums) {
            remaining.add(num);
        }

        for (int i = 0; i < nums.length; i++) {
            List<Integer> curr = new ArrayList<>();
            curr.add(nums[i]);
            remaining.remove(Integer.valueOf(nums[i]));

            dfs(curr, remaining);

            curr.remove(curr.size() - 1);
            remaining.add(nums[i]);
        }

        return resp;
    }

    private void dfs(List<Integer> curr, List<Integer> remaining) {
        if (remaining.size() == 0) {
            resp.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < remaining.size(); i++) {
            int currNum = remaining.get(i);
            curr.add(currNum);

            List<Integer> remaining2 = new ArrayList<>(remaining);
            remaining2.remove(Integer.valueOf(currNum));

            dfs(curr, remaining2);

            curr.remove(curr.size() - 1);
        }
    }
}
