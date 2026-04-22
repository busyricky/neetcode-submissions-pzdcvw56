class Solution {
    public boolean canPartition(int[] nums) {
        Set<Integer> sums = new HashSet<>();
        sums.add(0);
        int totalSum = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];

            int num = nums[i];

            List<Integer> list = new ArrayList<>();
            for (int sum : sums) {
                list.add(sum + num);
            }

            for (int sum : list) {
                sums.add(sum);
            }
        }

        return totalSum%2 == 0 ? sums.contains(totalSum / 2) : false;
    }
}
