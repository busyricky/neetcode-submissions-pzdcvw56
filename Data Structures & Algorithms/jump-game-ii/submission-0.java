class Solution {
    public int jump(int[] nums) {
        int r = 0, farthest = 0, jumps = 0;

        for (int l = 0; l < nums.length - 1; l++) {

            int num = nums[l];

            farthest = Math.max(farthest, l + num);

            if (r == l) {
                r = farthest;
                jumps++;

                if (r >= nums.length - 1) {
                    return jumps;
                }
            }
        }

        return jumps;
    }
}
