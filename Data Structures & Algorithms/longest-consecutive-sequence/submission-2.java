class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxLen = 0;

        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            if (!set.contains(num-1)) {
                int currLen = 1, currNum = num;
                while(set.contains(currNum+1)) {
                    currLen++;
                    currNum++;
                }

                maxLen = Math.max(maxLen, currLen);
            }
        }

        return maxLen;
    }
}
