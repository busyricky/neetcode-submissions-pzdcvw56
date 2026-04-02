class Solution {
    public boolean isPalindrome(String s) {
        String cleanedStr = s.toLowerCase().replaceAll("[^a-zA-Z0-9]","");

        int left = 0, right = cleanedStr.length() - 1;

        while (left < right) {
            if (cleanedStr.charAt(left) != cleanedStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
