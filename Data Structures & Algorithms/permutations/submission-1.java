class Solution {
    List<List<Integer>> resp;

    public List<List<Integer>> permute(int[] nums) {
        resp = new ArrayList<>();

        HashSet<Integer> remaining = new HashSet<>();
        for (int num : nums) {
            remaining.add(num);
        }

        List<Integer> curr = new ArrayList<>();
        dfs(curr, remaining);

        return resp;
    }

    private void dfs(List<Integer> curr, HashSet<Integer> remaining) {
        if (remaining.size() == 0) {
            resp.add(new ArrayList<>(curr));
            return;
        }

        HashSet<Integer> remaining2 = new HashSet<>(remaining);

        for (Integer num : remaining) {
            curr.add(num);
            remaining2.remove(num);

            dfs(curr, remaining2);

            curr.remove(curr.size() - 1);
            remaining2.add(num);
        }
    }
}
