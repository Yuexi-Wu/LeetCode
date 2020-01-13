class Solution {
    /**
    Similar to MeetingRoom2, use a sorted array and a heap, which sort head from small to large, another sort tail from large to small.
    **/
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        queue.add(intervals[0]);
        for (int[] interval : intervals) {
            int[] maxEnd = queue.remove();
            if (interval[0] <= maxEnd[1]) {
                maxEnd[0] = Math.min(interval[0], maxEnd[0]);
                maxEnd[1] = Math.max(interval[1], maxEnd[1]);
            } else {
                queue.add(interval);
            }
            queue.add(maxEnd);
        }
        return queue.toArray(new int[queue.size()][2]);
    }
}