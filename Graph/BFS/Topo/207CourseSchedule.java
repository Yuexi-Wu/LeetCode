class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //BFS -- topological sort
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        //degree is the number of prerequisite courses of current course
        int[] degree = new int[numCourses];
        //available is the list of courses whose prerequisite is current course
        List[] available = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            available[i] = new ArrayList<>();
        }
        for (int[] courses : prerequisites) {
            degree[courses[0]]++;
            available[courses[1]].add(courses[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int cur = queue.poll();
            int num = available[cur].size();
            for (int i = 0; i < num; i++) {
                int node = (int)available[cur].get(i);
                degree[node]--;
                if (degree[node] == 0) {
                    queue.add(node);
                }
            }
        }
        //Cannot judge by queue.size() == numCourses cus the queue is empty at last...so we need an int count to count how many elements had been in queue.
        return count == numCourses;
    }
}
