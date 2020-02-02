This is an easy BFS problem, easy to figure. As usual, we use a queue to keep rotted oranges, 
and we pop out each rotted and make oranges around it go bad, then put into queue also. 
Besides that, we need a hashmap to record the time for each position to rot.



class Solution {
    int[] rw = new int[]{-1, 0, 1, 0};
    int[] cl = new int[]{0, -1, 0, 1};
    public int orangesRotting(int[][] grid) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0 ; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    int position = col * i + j;
                    queue.add(position);
                    map.put(position, 0);
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int position = queue.remove();
                int cur_row = position / col;
                    int cur_col = position % col;
                    for (int k = 0; k < 4; k++) {
                        int new_row = cur_row + rw[k];
                        int new_col = cur_col + cl[k];
                        if (new_row >= 0 && new_row < row && new_col >= 0 && new_col < col && grid[new_row][new_col] == 1) {
                            grid[new_row][new_col] = 2;
                            int new_position = new_row * col + new_col;
                            queue.add(new_position);
                            map.put(new_position, map.get(position) + 1);
                            ans = Math.max(ans, map.get(new_position));
                        }
                    }
                }
        
        for (int[] r : grid) {
            for (int val : r) {
                if (val == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }
}