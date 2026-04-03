class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> resp = new ArrayList<String>();

        helper(n*2, resp, new ArrayList<>(), 0);

        return resp;
    }

    private void helper(int n, List<String> resp, List<String> currList, int open) {
        if (n <= 0) {
            if (open == 0) {
                resp.add(stringify(currList));
            }
            return;
        }

        currList.add("(");
        helper(n-1, resp, currList, open+1);

        currList.remove(currList.size() - 1);
        if (open > 0) {
            currList.add(")");
            helper(n-1, resp, currList, open-1);
            currList.remove(currList.size() - 1);
        }
    }

    private String stringify(List<String> list) {
        String r = "";

        for (String s : list) {
            r += s;
        }

        return r;
    }
}
