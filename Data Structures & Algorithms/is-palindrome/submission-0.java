class Solution {
    public boolean isPalindrome(String s) {
        String cleanedStr = s.toLowerCase().replaceAll("[^a-zA-Z0-9]","");

        int low = 0, high = cleanedStr.length() - 1;

        while (low < high) {
            char lowChar = cleanedStr.charAt(low);
            char highChar = cleanedStr.charAt(high);

            if (lowChar != highChar) {
                return false;
            }

            low++;
            high--;
        }

        return true;
    }
}
