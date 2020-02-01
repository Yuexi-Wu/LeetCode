class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0 || matrix == null) {
            return false;
        }
        int len = matrix.length;
        int row = len - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (target < matrix[row][col]) {
                row--;
            } else if (target > matrix[row][col]) {
                col++;
            } else if (target == matrix[row][col]){
                return true;
            }
            
        }
        return false;
    }
}

Time complexity: O(n)
search from the left-bootom corner, and check bigger or smaller to decide go top or right. At most n comparisons.