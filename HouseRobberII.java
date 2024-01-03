class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
       // int[] memo = new int[nums.length];
       // Arrays.fill(memo, -1);
        int skipEnd = helper(1, n-2, nums, nums[0]);
       // Arrays.fill(memo, -1);
        int skipStart = helper(2, n-1, nums, nums[1]);
        return Math.max(skipEnd, skipStart);
    }

    // public int helper(int index, int end, int[] nums, int[] memo) {
    //     if(index > end) {
    //         return 0;
    //     }
    //     if(memo[index] != -1) return memo[index];
    //     int take = nums[index] + helper(index+2, end, nums, memo);
    //     int not_take = helper(index+1, end, nums, memo);
    //     return memo[index] = Math.max(take, not_take);
    // }
    public int helper(int start, int end, int[] nums, int prev) {
        int prev2 = 0;
        for(int i = start; i <= end; i++) {
            int take = nums[i] + prev2;
            int not_take = prev;
            int curr = Math.max(take, not_take);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}