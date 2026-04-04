class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> resp = new ArrayList<>();

        helper(s, resp, new ArrayList<>(), 0, 0);

        return resp;
    }

    private void helper(String s, List<List<String>> resp, List<String> currList, int strIdx, int listIdx) {
        if (listIdx >= currList.size()) {
            currList.add("");
        }

        if (strIdx >= s.length()) {
            if (isPalindrome(currList.get(currList.size() - 1))) {
                resp.add(new ArrayList<>(currList));
            }
            return;
        }

        if (isPalindrome(currList.get(currList.size() - 1))) {
            helper(s, resp, currList, strIdx, listIdx + 1);
            currList.remove(listIdx + 1);
        }

        String newStr = currList.get(listIdx) + s.charAt(strIdx);
        currList.remove(listIdx);
        currList.add(newStr);

        helper(s, resp, currList, strIdx + 1, listIdx);
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
