class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalMultProduct = 1;
        boolean hasZero = false;
        int[] response = new int[nums.length];

        for (int num : nums) {
            if (num != 0) {
                totalMultProduct = totalMultProduct * num;
            } else if (num == 0) {

                if (hasZero) { return response; }

                hasZero = true;
            }
        }

        if (hasZero) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    response[i] = totalMultProduct;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                response[i] = totalMultProduct/nums[i];
            }  
        }

        return response;
    }
}  
