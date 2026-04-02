class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] resp = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i-1 >= 0) {
                prefix[i] = prefix[i-1] * nums[i-1];
            } else {
                prefix[i] = 1;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i+1 < nums.length) {
                suffix[i] = suffix[i+1] * nums[i+1];
            } else {
                suffix[i] = 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            resp[i] = prefix[i] * suffix[i];
        }
        
        return resp;
    }
}  
