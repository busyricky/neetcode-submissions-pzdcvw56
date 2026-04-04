class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> resp = new ArrayList<>();

        helper(s, resp, new ArrayList<>(), 0);

        return resp;
    }

    private void helper(String s, List<List<String>> resp, List<String> currList, int start) {
        // some base case
        if (start >= s.length()) {
            resp.add(new ArrayList<>(currList));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (isPalindrome(sub)) {
                currList.add(sub);
                helper(s, resp, currList, i + 1);
                currList.remove(currList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return false;
        }

        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
