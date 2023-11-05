class Solution {
    public int[] productExceptSelf(int[] nums) {
        //TC : O(N)
        //SC : O(N)
        // int n = nums.length;
        // int[] leftArray = new int[n];
        // int[] rightArray = new int[n];
        // int[] res = new int[n];
        // leftArray[0] = 1;
        // rightArray[n-1] = 1;

        // for(int i = 1; i < n; i++) {
        //     leftArray[i] = leftArray[i-1] * nums[i-1];
        // }
        // for(int i = n-2; i >= 0; i--) {
        //     rightArray[i] = rightArray[i+1] * nums[i+1];
        // }
        // for(int i = 0; i < n; i++) {
        //     res[i] = leftArray[i] * rightArray[i];
        // }
        // return res;

        //TC : O(N)
        //SC : O(1)
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        int right = 1;
        for(int i = 1; i < n; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        
        for(int i = n-1; i >= 0; i--) {
            res[i] = right * res[i];
            right *= nums[i];
        }
        return res;
    }
}