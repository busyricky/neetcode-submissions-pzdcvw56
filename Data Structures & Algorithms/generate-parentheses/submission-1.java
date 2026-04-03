class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> resp = new ArrayList<String>();

        helper(n*2, resp, "", 0);

        return resp;
    }

    private void helper(int n, List<String> resp, String curr, int open) {
        if (n <= 0) {
            if (open == 0) {
                resp.add(curr);
            }
            return;
        }

        curr += "(";
        helper(n-1, resp, curr, open+1);

        curr = curr.substring(0, curr.length() - 1);
        if (open > 0) {
            curr += ")";
            helper(n-1, resp, curr, open-1);
            curr = curr.substring(0, curr.length() - 1);
        }
    }
}
