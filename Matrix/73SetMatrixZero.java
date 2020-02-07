class Solution {
    public void setZeroes(int[][] matrix) {
        //Use flags
        boolean isrow = false;
        boolean iscol = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    //use two booleans to check whether first row ans forst col should be changed to 0.
                    if (i == 0) {
                        iscol = true;
                    }
                    if (j == 0) {
                        isrow = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //skip i = 0 and j = 0 to avoid changing all elements to 0.
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                } 
            }
        }
        if (iscol) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (isrow) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
