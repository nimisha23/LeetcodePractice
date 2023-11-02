class Solution {
    public int arrangeCoins(int n) {
        //By arithmetic progression we know that 1+2+3+4+..n = n(n+1)/2, so we will find index where the ap sum is <= n
        //imp: if we use all int, then some testcases will not pass because of integer overflow which can happen when we do mid*(mmid+1), so use long and cast res to int
        long low = 1; long high = n;
        long res = 0;
        while(low <= high) {
            long mid = low + (high-low)/2;
            long sum = (mid*(mid+1))/2;
            if(sum > n) {
                high = mid-1;
            } else {
                //if sum < n or == n, we will initialize res
                res = Math.max(res, mid);
                low = mid+1;
            }
        }
        return (int)res;
    }
}   