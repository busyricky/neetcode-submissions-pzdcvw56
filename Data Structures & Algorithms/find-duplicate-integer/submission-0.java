class Solution {
    public int findDuplicate(int[] nums) {
        int curr = 0;

        while (nums[curr] != 0) {
            int temp = nums[curr];
            nums[curr] = 0;
            curr = temp;
        }

        return curr;
    }
}
