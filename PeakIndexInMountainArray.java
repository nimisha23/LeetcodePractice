class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 1; //imp to note
        int high = arr.length-2; //imp to note

        while(low <= high) {
            int mid = low + (high-low)/2;
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) { //peak found
                return mid;
            } else if (arr[mid] > arr[mid-1]) { //here it is increasing, so peak will be further ahead
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}