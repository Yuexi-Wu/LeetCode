class Solution {
    public int[][] generateMatrix(int n) {
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int[][] matrix = new int[n][n];
        int cur = 1;
        while (cur <= n*n) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = cur;
                cur++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = cur;
                cur++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = cur;
                cur++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = cur;
                cur++;
            }
            left++;
        }
        return matrix;
    }
}
