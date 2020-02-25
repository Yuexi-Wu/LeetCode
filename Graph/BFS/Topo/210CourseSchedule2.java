class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        //degree: number of prequisites
        int[] degree = new int[numCourses];
        //available: courses become available after taking current course
        List[] available = new ArrayList[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            available[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            degree[pre[0]]++;
            available[pre[1]].add(pre[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        int index = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int cur = queue.poll();
            res[index++] = cur;
            for (int i = 0; i < available[cur].size(); i++) {
                int next = (int)available[cur].get(i);
                degree[next]--;
                if (degree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        if (count != numCourses) {
            return new int[]{};
        }
        return res;
    }
}