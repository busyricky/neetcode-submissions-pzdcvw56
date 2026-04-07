class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        int[] max = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            int oneIdx = 0, twoIdx = 0;

            if (i+2 < nums.length) {
                oneIdx = max[i+2];
            }

            if (i+3 < nums.length) {
                twoIdx = max[i+3];
            }

            max[i] = nums[i] + Math.max(oneIdx, twoIdx);
        }

        return Math.max(max[0],max[1]);
    }
}
