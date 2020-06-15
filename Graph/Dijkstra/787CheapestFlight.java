class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // build adjacency matrix
        int[][] matrix = new int[n][n];
        for (int[] flight : flights) {
            matrix[flight[0]][flight[1]] = flight[2];
        }
        // record shortest distance and min stops
        int[] distance = new int[n];
        int[] stops = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(stops, Integer.MAX_VALUE);
        distance[src] = 0;
        stops[src] = 0;
        // min heap stores int[city, minDistance, stop]
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        queue.add(new int[]{src, 0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int name = cur[0], curdis = cur[1], curstop = cur[2];
            if (name == dst) {
                return curdis;
            }
            if (curstop > K) {
                continue;
            }
            // discover neighbors
            for (int i = 0; i < n; i++) {
                if (matrix[name][i] > 0) {
                    // update
                    if (matrix[name][i] + curdis < distance[i]) {
                        distance[i] = matrix[name][i] + curdis;
                        queue.add(new int[]{i, matrix[name][i] + curdis, curstop+1});
                    } else {
                        if (curstop < stops[i]) {
                            stops[i] = curstop;
                            queue.add(new int[]{i, matrix[name][i] + curdis, curstop+1});
                        }
                    }
                }
            }
        }
        return distance[dst] == Integer.MAX_VALUE? -1 : distance[dst];
    }
}
