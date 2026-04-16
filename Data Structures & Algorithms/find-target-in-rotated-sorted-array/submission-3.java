class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r-l)/2;
            int midVal = nums[mid], lVal = nums[l], rVal = nums[r];

            if (midVal == target) {
                return mid;
            }
            
            if (midVal >= lVal) {
                if (lVal <= target && midVal > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (midVal < target && target <= rVal) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}
