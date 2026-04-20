class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int currSum = 0, subarrs = 0;

        map.put(currSum, 1);

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];

            int diff = currSum - k;

            subarrs += map.getOrDefault(diff, 0);

            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }

        return subarrs;
    }
}