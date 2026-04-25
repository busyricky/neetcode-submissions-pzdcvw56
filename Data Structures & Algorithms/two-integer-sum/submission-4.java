class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];

            if (!map.containsKey(curr)) {
                map.put(target - curr, i);
            } else {
                return new int[]{map.get(curr), i};
            }
        }

        return new int[]{-1,-1};
    }
}
