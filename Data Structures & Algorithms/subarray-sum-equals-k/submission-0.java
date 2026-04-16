class Solution {
    public int subarraySum(int[] nums, int k) {
        int sumSoFar = 0, resp = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        for (int i = 0; i < nums.length; i++) {
            sumSoFar += nums[i];

            if (map.containsKey(sumSoFar - k)) {
                resp += map.get(sumSoFar - k);
            }

            map.put(sumSoFar, map.getOrDefault(sumSoFar,0) + 1);
        }

        return resp;
    }
}