class Solution {
    //DFS: using recursion
    //create two two-dimention boolean types arrays, one represents whether can reach Pacific. Another represents Atlantic.
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dir = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        boolean[][] Pacific = new boolean[m][n];
        boolean[][] Atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(Pacific, matrix, dir, i, 0, 0);
            dfs(Atlantic, matrix, dir, i, n-1, 0);
            
        }
        for (int i = 0; i < n; i++) {
            dfs(Pacific, matrix, dir, 0, i, 0);
            dfs(Atlantic, matrix, dir, m-1, i, 0);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (Pacific[i][j] && Atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
    
    private void dfs(boolean[][] visited, int[][] matrix, int[][] dir, int i, int j, int height){
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j] || matrix[i][j] < height) {
            return;
        }
        visited[i][j] = true;
        for (int[] direction : dir) {
            dfs(visited, matrix, dir, i + direction[0], j + direction[1], matrix[i][j]);
        }
    }
}



/**
    BFS: time limit exceeded
**/
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] Pacific = new boolean[m][n];
        boolean[][] Atlantic = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            Pacific[i][0] = true;
            queue.add(new int[]{i, 0});
        }
        for (int i = 0; i < n; i++) {
            Pacific[0][i] = true;
            queue.add(new int[]{0, i});
        }
        int[][] dir = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] direction : dir) {
                int x = current[0] + direction[0];
                int y = current[1] + direction[1];
                if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] >= matrix[current[0]][current[1]]) {
                    Pacific[x][y] = true;
                    queue.add(new int[]{x, y});
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            Atlantic[i][n-1] = true;
            queue.add(new int[]{i, n-1});
        }
        for (int i = 0; i < n; i++) {
            Atlantic[m-1][i] = true;
            queue.add(new int[]{m-1, i});
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (Pacific[current[0]][current[1]]) {
                result.add(new ArrayList(Arrays.asList(current)));
            }
            for (int[] direction : dir) {
                int x = current[0] + direction[0];
                int y = current[1] + direction[1];
                if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] >= matrix[current[0]][current[1]]) {
                    Atlantic[x][y] = true;
                    queue.add(new int[]{x, y});
                }
            }
        }
        return result;
    }