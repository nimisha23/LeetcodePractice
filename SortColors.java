class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int p0 = 0;
        int p2 = len-1;
        int curr = 0;

        while(curr <= p2) {
            if(nums[curr] == 0) {
                int temp = nums[p0];
                nums[p0] = nums[curr];
                nums[curr] = temp;
                curr++;
                p0++;
            } else if(nums[curr] == 2) {
                int temp = nums[p2];
                nums[p2] = nums[curr];
                nums[curr] = temp;
                p2--;
            } else {
                curr++;
            }
        }
    }
}