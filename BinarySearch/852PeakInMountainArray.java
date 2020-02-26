class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int left = 0, right = A.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] < A[mid+1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return A[left] > A[right] ? left : right;
    }
}
