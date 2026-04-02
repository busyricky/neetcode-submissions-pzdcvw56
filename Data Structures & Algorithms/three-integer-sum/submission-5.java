class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> response = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            int first = nums[i];

            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int low = i + 1, high = nums.length-1;

            while (low < high) {
                int sum = first + nums[low] + nums[high];

                if (sum == 0) {
                    response.add(Arrays.asList(first,nums[low],nums[high]));
                    low++;
                    while (low < nums.length && nums[low] == nums[low-1]) {
                        low++;
                    }
                } else if (sum < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return response;
    }
}
