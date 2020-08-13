class Solution {
    // [2],
    // [3,4],
    // [6,5,7],
    // [4,1,8,3] => (x, y) can goes to (x+1, y) or (x+1, y+1)
    /**
    * dfs
    */
//     int minPath = Integer.MAX_VALUE;
//     public int minimumTotal(List<List<Integer>> triangle) {
//         dfs(triangle, 0, 0, 0);
//         return minPath;
//     }
    
//     private void dfs(List<List<Integer>> triangle, int x, int y, int path) {
//         if (x == triangle.size()) {
//             minPath = Math.min(path, minPath);
//             return;
//         }
//         dfs(triangle, x+1, y, path + triangle.get(x).get(y));
//         dfs(triangle, x+1, y+1, path + triangle.get(x).get(y));
//     }
    /**
    * divide and conquer
    */
//     public int minimumTotal(List<List<Integer>> triangle) {
//         return divideConquer(0, 0, triangle);
//     }
    
//     private int divideConquer(int x, int y, List<List<Integer>> triangle) {
//         if (x == triangle.size()) {
//             return 0;
//         }
//         int left = divideConquer(x+1, y, triangle);
//         int right = divideConquer(x+1, y+1, triangle);
//         return Math.min(left, right) + triangle.get(x).get(y);
//     }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] memo = new int[n][n];
        return divideConquer(0, 0, memo, triangle);
    }
    
    private int divideConquer(int x, int y, int[][] memo, List<List<Integer>> triangle) {
        if (x == triangle.size()) {
            return 0;
        }
        if (memo[x][y] != 0) {
            return memo[x][y];
        }
        int left = divideConquer(x+1, y, memo, triangle);
        int right = divideConquer(x+1, y+1, memo, triangle);
        memo[x][y] = Math.min(left, right) + triangle.get(x).get(y);
        return memo[x][y];
    }
}
