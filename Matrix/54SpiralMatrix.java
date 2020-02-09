class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //layer by layer
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        if (matrix.length == 0 || matrix == null) {
            return list;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int cur_row = row, cur_col = col;
        int count = row > col ? (col + 1) / 2 : (row + 1) / 2;
        for (int i = 0; i < count; i++, cur_row -= 2, cur_col -= 2) {
            for (int p = i; p < i + cur_col; p++) {
                list.add(matrix[i][p]);
            }
            for (int q = i + 1; q < i + cur_row; q++) {
                list.add(matrix[q][i + cur_col - 1]);
            }
            //This part is important, if there is only one line or one column, reduce duplication.
            if (cur_col == 1 || cur_row == 1) {
                break;
            }
            for (int p = i + cur_col - 2; p >= i; p--) {
                list.add(matrix[i + cur_row - 1][p]);
            }
            for (int q = i + cur_row - 2; q > i; q--) {
                list.add(matrix[q][i]);
            }
        }
        return list;
    }
}
