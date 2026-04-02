class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left)/2);
            int m = nums[mid], l = nums[left], r = nums[right];

            if (m == target) {
                return mid;
            } else if (m > r) { //unsorted
                if (target > m || target <= r) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else { //sorted
                if (target > m && target <= r) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
