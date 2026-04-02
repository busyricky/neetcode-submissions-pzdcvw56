class Solution {
    public int maxArea(int[] heights) {
        int maxSize = 0;

        for (int l = 0; l < heights.length - 1; l++) {
            for (int r = heights.length - 1; r > l; r--) {
                int currContainerSize = Math.min(heights[r], heights[l]) * (r-l);

                maxSize = Math.max(maxSize, currContainerSize);
            }
        }

        return maxSize;
    }
}
