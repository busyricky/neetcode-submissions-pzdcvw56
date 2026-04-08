class Solution {
    public void sortColors(int[] nums) {
        int start = 0, end = nums.length - 1, curr = 0;

        while (curr <= end) {
            int num = nums[curr];

            if (num == 1 || curr < start) {
                curr++;
            } else if (num == 0) {
                swap(nums, start, curr);
                start++;
            } else if (num == 2) {
                swap(nums, end, curr);
                end--;
            }
            
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}