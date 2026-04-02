class Solution {
    public int[] productExceptSelf(int[] nums) {
        int preProduct = 1, postProduct = 1, temp = 1;
        int[] response = new int[nums.length];

        //init response array
        for (int i = 0; i < response.length; i++) {
            response[i] = 1;
        }

        //preProduct
        for (int i = 0; i < nums.length; i++) {
            temp = preProduct * nums[i];
            response[i] = preProduct;
            preProduct = temp;
        }

        //postProduct
        for (int i = nums.length-1; i >= 0; i--) {
            temp = postProduct * nums[i];
            response[i] = postProduct * response[i];
            postProduct = temp;
        }

        return response;
    }
}  
