class Solution {
    public int longestOnes(int[] nums, int k) {
         //Using sliding window approach
        int n = nums.length;
        int len = 0;
        int left = 0;
        int right = 0;
        int numZero = 0;
        while(right < n) {
            if(nums[right] == 0) {
                numZero++;
            }
            while(numZero > k) {
                if(nums[left] == 0) {
                    numZero--;
                }
                left++;
            }
            len = Math.max(len, right-left+1);
            right++;
        }
        return len;
    }
}