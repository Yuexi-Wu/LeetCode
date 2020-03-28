class Solution {
    public int[] sortArrayByParity(int[] A) {
        int left = 0, right = A.length - 1;
        while (left < right) {
            if (A[left] % 2 == 1 && A[right] % 2 == 0) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            } else if(A[left] % 2 == 1 && A[right] % 2 == 1) {
                right--;
            } else if (A[left] % 2 == 0 && A[right] % 2 == 0) {
                left++;
            } else {
                left++;
                right--;
            }
        }
        return A;
    }
}
