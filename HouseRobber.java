class Solution {
    int sum;
    int max;
    int[] memo;
    public int rob(int[] nums) {
        // sum = 0;
        // memo = new int[nums.length+1];
        // Arrays.fill(memo, -1);
        // return helper(nums, 0, memo);
        int[] dp = new int[nums.length];
        int prev2 = 0;
        int prev1 = nums[0];
        int curr = 0;

        for(int i = 1; i < nums.length; i++) {
            int take = nums[i] + prev2;
            int not_take = prev1;
            curr = Math.max(take, not_take);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    // public int helper(int[] nums, int index, int[] memo) {
    //     if(index >= nums.length) {
    //         return 0;
    //     }
    //     if(memo[index] != -1) return memo[index];
    //     //take
    //     int take = nums[index] + helper(nums, index+2, memo);
    //     //not take
    //     int not_take = helper(nums, index+1, memo);
    //     return memo[index] = Math.max(take, not_take);
    // }
}