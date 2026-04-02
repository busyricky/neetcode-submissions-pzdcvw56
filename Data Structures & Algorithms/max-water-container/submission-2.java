class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1, maxArea = 0;

        while (left < right) {
            int currArea = Math.min(heights[left], heights[right]) * (right - left);
            maxArea = Math.max(maxArea, currArea);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
