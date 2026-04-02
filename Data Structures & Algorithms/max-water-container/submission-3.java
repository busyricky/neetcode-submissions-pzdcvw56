class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1, max = 0;
        
        while (l < r) {
            int lH = heights[l], rH = heights[r];
            int currVol = Math.min(lH, rH) * (r-l);

            max = Math.max(max, currVol);

            if (lH < rH) {
                l++;
            } else {
                r--;
            }
        }

        return max;
    }
}
