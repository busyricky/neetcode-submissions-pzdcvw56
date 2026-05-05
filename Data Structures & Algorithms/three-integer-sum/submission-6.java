class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> resp = new ArrayList<>();

        int i = 0;

        while (i < nums.length - 2) {
            int l = i + 1, r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if (sum == 0) {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(nums[i]);
                    newList.add(nums[l]);
                    newList.add(nums[r]);
                    resp.add(newList);
                    
                    l++;
                    while (l < r && nums[l] == nums[l-1]) {
                        l++;
                    }

                    r--;
                    while (l < r && nums[r] == nums[r+1]) {
                        r--;
                    }
                    
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }

            i++;
            while (i < nums.length - 2 && nums[i] == nums[i-1]) {
                i++;
            }
        }

        return resp;
    }
}
