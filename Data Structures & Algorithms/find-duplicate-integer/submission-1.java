class Solution {
    public int findDuplicate(int[] nums) {
        //fast and slow pointers
        int fast = 0, slow = 0;
        while (slow == 0 || slow != fast) {
            fast = nums[fast];
            fast = nums[fast];
            slow = nums[slow];
        }

        //slow and new slow pointer
        int newSlow = 0;
        while (slow != newSlow) {
            newSlow = nums[newSlow];
            slow = nums[slow];
        }

        //return intersection of slow and new slow pointer
        return newSlow;
    }
}
