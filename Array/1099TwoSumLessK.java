class Solution {
    //Brute Force
    public int twoSumLessThanK(int[] A, int K) {
        int len = A.length;
        int ans = -1;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (A[i] + A[j] < K) {
                    ans = Math.max(ans, A[i] + A[j]);
                }
            }
        }
        return ans;
    }
    //Use two pointers
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int ans = -1;
        int head = 0, tail = A.length - 1;
        while (head < tail) {
            if (A[head] + A[tail] >= K) {
                tail--;
            } else {
                ans = Math.max(ans, A[head] + A[tail]);
                head++;
            }
        }
        return ans;
    }
}