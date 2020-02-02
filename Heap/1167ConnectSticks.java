class Solution {
    public int connectSticks(int[] sticks) {
        //greedy: everytime choose the smallest two to connect.
        Arrays.sort(sticks);
        int cost = 0;
        int index = 0;
        while (index < sticks.length - 1) {
            int cur_cost = sticks[index] + sticks[index+1];
            sticks[index+1] = cur_cost;
            Arrays.sort(sticks, index+1, sticks.length);
            cost += cur_cost;
            index++;
        }
        return cost;

        //Use heap to sort
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> (a-b));
        if (sticks.length == 1) {
            return 0;
        }
        for (int stick : sticks) {
            minHeap.add(stick);
        }
        int cost = 0;
        while (minHeap.size() != 1) {
            int first = minHeap.remove();
            int second = minHeap.remove();
            int cur_cost = first + second;
            cost += cur_cost;
            minHeap.add(cur_cost);
        }
        return cost;
    }
}