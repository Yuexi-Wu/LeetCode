public class Solution {
    /*
     * @param A: An integer array.
     * @return: nothing
     */
    public void rerange(int[] A) {
        // write your code here
        int n = A.length;
        int posnum = 0;
        int lastpos = 0;
        int pos = 1, neg = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] > 0) {
                swap(lastpos, i, A);
                posnum++;
                lastpos++;
            }
        }
        if (posnum < n/2) {
            pos = 0;
            neg = 1;
        }
        while (pos < n && neg < n) {
            while (pos < n && A[pos] > 0) {
                pos += 2;
            }
            while (neg < n && A[neg] < 0) {
                neg += 2;
            }
            if (pos >= n || neg >= n) {
                break;
            }
            swap(pos, neg, A);
        }
    }
    
    private void swap(int i, int j, int[] A) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
