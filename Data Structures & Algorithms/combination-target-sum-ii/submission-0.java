class Solution {
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> resp = new ArrayList<>();

        dfs(candidates, target, resp, 0, new ArrayList<>());

        return resp;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> resp, int i, List<Integer> curr) {
        if (i >= candidates.length || target <= 0) {
            if (target == 0) {
                resp.add(new ArrayList<>(curr));
            }
            return;
        }

        curr.add(candidates[i]);
        dfs(candidates, target-candidates[i], resp, i+1, curr);

        int j = i;

        while (j + 1 < candidates.length && candidates[j] == candidates[j+1]) {
            j++;
        }

        curr.remove(curr.size() - 1);
        dfs(candidates, target, resp, j+1, curr);
    }
}
