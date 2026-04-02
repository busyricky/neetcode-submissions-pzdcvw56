class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] resp = new int[nums.length];
        int product = 1;
        boolean zeroExists = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (zeroExists) { return new int[nums.length]; }
                zeroExists = true;
            } else {
                product = product * nums[i];
            }
        } 

        // check is there a zero? if so then it's easy
        if (zeroExists) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    resp[i] = product;
                } else {
                    nums[i] = 0;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                resp[i] = product / nums[i];
            }
        }
        
        return resp;
    }
}  
