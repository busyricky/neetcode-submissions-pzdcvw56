class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> response = new ArrayList<>();

        Arrays.sort(nums);

        for (int curr = 0; curr < nums.length - 2; curr++) {
            if (curr > 0 && nums[curr] == nums[curr-1]) {
                continue;
            }

            int left = curr + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[curr] + nums[left] + nums[right];

                if (sum > 0) {
                    right--;
                    while(right > 0 && nums[right] == nums[right+1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                    while(left < nums.length - 1 && nums[left] == nums[left-1]) {
                        left++;
                    }
                } else {
                    response.add(new ArrayList(List.of(nums[curr], nums[left], nums[right])));
                    left++;
                    while(left < nums.length - 1 && nums[left] == nums[left-1]) {
                        left++;
                    }
                }
            }
        }

        return response;
    }
}
