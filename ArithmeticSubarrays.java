class Solution {
    //TC : O(M* N log N) -> where M is the length of queries array and N is the size of query, in the worst case it will be the length of nums array N, so N log N because we are sorting subarray and M times we will do these steps
    //SC : O(N)
    // public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
    //     int len = l.length;
    //     List<Boolean> res = new ArrayList<>();

    //     for(int i = 0; i < len; i++) {
    //         int start = l[i];
    //         int end = r[i];

    //         int subLen = end-start+1;
    //         int[] arr = new int[subLen];
    //         for(int k = 0; k < subLen; k++) {
    //             arr[k] = nums[start+k];
    //         }
    //         check(arr, res, subLen);
    //     }
    //     return res;
    // }

    // public void check(int[] arr, List<Boolean> res, int subLen) {
    //     Arrays.sort(arr);
    //     int diff = arr[1] - arr[0];
    //     int k = 1;
    //     for(; k < subLen-1; k++) {
    //         if(arr[k+1] - arr[k] != diff) {
    //             res.add(Boolean.FALSE);
    //             break;
    //         }
    //     }
    //     if(k == subLen-1) {
    //         res.add(Boolean.TRUE);
    //     }
    // }

    //TC : O(M*N)
    //SC : O(N)
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int len = l.length;
        List<Boolean> res = new ArrayList<>();

        for(int i = 0; i < len; i++) {
            int start = l[i];
            int end = r[i];
            int minElement = Integer.MAX_VALUE;
            int maxElement = Integer.MIN_VALUE;

            int subLen = end-start+1;
            HashSet<Integer> set = new HashSet<>();
            for(int k = 0; k < subLen; k++) {
                minElement = Math.min(minElement, nums[start+k]);
                maxElement = Math.max(maxElement, nums[start+k]);
                set.add(nums[start+k]);
            }
            check(set, res, subLen, minElement, maxElement);
        }
        return res;
    }

    public void check(HashSet<Integer> set, List<Boolean> res, int subLen, int min, int max) {
        if((max-min)%(subLen-1) != 0) {
            res.add(Boolean.FALSE);
            return;
        }
        int diff = (max-min)/(subLen-1);
        while(min != max) {
            min += diff;
            if(!set.contains(min)) {
                res.add(Boolean.FALSE);
                return;
            }
        }
        res.add(Boolean.TRUE);
    }
}