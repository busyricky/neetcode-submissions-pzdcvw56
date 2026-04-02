class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + ((right - left)/2);

            if (nums[mid] < nums[left]) {
                right = mid;
            } else if (nums[mid] > nums[left]) {
                left = mid;
            } else {
                return Math.min(nums[left], nums[right]);
            }
        }

        return 0;
    }
}
