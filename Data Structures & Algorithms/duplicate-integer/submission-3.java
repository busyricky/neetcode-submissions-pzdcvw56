class Solution {
    public boolean hasDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;


        // Set<Integer> set = new HashSet<>();
        // for (int i : nums) {
        //     if (!set.isEmpty() && set.contains(i)) {
        //         return true;
        //     }
        //     set.add(i);
        // }
        // return false;
    }
}