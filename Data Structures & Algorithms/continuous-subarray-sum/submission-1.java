class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int psum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);

        for (int i = 0; i < nums.length; i++) {
            psum += nums[i];

            int modulo = psum % k;

            if ((map.containsKey(modulo) && i-2 >= map.get(modulo))) {
                return true;
            }

            if (!map.containsKey(modulo)) {
                map.put(modulo, i);
            }
        }

        return false;
    }
}