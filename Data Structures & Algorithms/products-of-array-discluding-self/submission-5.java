class Solution {
    public int[] productExceptSelf(int[] nums) {
        // int[] prefix = new int[nums.length];
        // int[] suffix = new int[nums.length];
        int[] resp = new int[nums.length];

        for (int i = 0 ; i < nums.length; i++) {
            if (i == 0) {
                resp[i] = 1;
            } else {
                resp[i] = resp[i-1] * nums[i-1];
            }
        }

        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            resp[i] = resp[i] * suffix;
            
            suffix = suffix * nums[i];
        }

        return resp;
    }
}  
