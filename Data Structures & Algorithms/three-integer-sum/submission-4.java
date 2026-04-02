class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> response = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) { break; }

            int currValue = nums[i], left = i+1, right = nums.length - 1;

            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            while (left < right) {
                int sum = currValue + nums[left] + nums[right];

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    response.add(new ArrayList(List.of(currValue, nums[left], nums[right])));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                }
            }
        }

        return response;
    }
}
