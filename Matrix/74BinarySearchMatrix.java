class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // Brute force
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        int row = matrix.length;
        int col = matrix[0].length;
        //Binary Search
        int left = 0, right = row * col - 1;
        int mid = 0, cur_row = 0, cur_col = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            cur_row = mid/col;
            cur_col = mid % col;
            if (target == matrix[cur_row][cur_col]) {
                return true;
            } else {
                if (target < matrix[cur_row][cur_col]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
