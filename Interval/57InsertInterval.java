class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        int index = 0;
        List<int[]> result = new ArrayList<>();
        int[] merge = new int[2];
        //First insert all intervals that begins before newInterval begins
        while (index < len && intervals[index][0] < newInterval[0]) {
            System.out.println(1);
            result.add(intervals[index++]);
        }
        //Then insert the newInterval but check whether need merge meanwhile.
        if (result.isEmpty() || result.get(result.size() - 1)[1] < newInterval[0]) {
            System.out.println(2);
            result.add(newInterval);
        } else {
            merge = result.remove(result.size() - 1);
            merge[1] = Math.max(merge[1], newInterval[1]);
            System.out.println(3);
            result.add(merge);
        }
        //Finally, insert all left intervals and check whether merges are needed.
        while (index < len) {
            int[] current = intervals[index++];
            if (current[0] > result.get(result.size() - 1)[1]) {
                System.out.println(4);
                result.add(current);
            } else {
                merge = result.remove(result.size() - 1);
                merge[1] = Math.max(merge[1], current[1]);
                System.out.println(5);
                result.add(merge);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}