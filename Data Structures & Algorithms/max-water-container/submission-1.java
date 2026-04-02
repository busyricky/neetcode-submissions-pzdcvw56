class Solution {
    public int maxArea(int[] heights) {
        int maxSize = 0, left = 0, right = heights.length - 1;

        while (left < right) {
            int lH = heights[left], rH = heights[right];
            int currSize = (right-left) * Math.min(lH, rH);

            maxSize = Math.max(maxSize, currSize);

            if (lH < rH) {
                left++;
            } else {
                right--;
            }
        }

        return maxSize;
    }
}
