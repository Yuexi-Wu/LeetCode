class Solution {
    public int minKnightMoves(int x, int y) {
        //BFS
        if (x == 0 && y == 0) {
            return 0;
        }
        int[] dx = new int[]{1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = new int[]{2, -2, 2, -2, 1, -1, 1, -1};
        // Set<int[]> visited = new HashSet<>();
        boolean[][] visited = new boolean[601][601];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{0, 0});
        int move = 0;
        
        while (!queue.isEmpty()) {
            move++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                
                for (int k = 0; k < 8; k++) {
                    int newX = cur[0] + dx[k];
                    int newY = cur[1] + dy[k];
                    if (newX == x && newY == y) {
                        return move;
                    }
                    if (!visited[newX+300][newY+300]){
                    // if (!visited.contains(new int[]{newX, newY})) {
                        queue.offer(new int[]{newX, newY});
                        // visited.add(new int[]{newX, newY});
                        visited[newX+300][newY+300] = true;
                    }
                }
            }
            
        }
        return -1;
    }
}
