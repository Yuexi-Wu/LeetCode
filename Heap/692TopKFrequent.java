class Solution {
    public List<String> topKFrequent(String[] words, int k) {


        //Use Collection sorting
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 1) + 1);
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) ->((map.get(a) == map.get(b)) ? a.compareTo(b) : map.get(b) - map.get(a)));
        return list.subList(0, k);




        //hashmap and heap
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<String> maxHeap = new PriorityQueue<>((a, b) ->((map.get(a) == map.get(b)) ? a.compareTo(b) : map.get(b) - map.get(a)));
        for (String word : map.keySet()) {
            maxHeap.add(word);
        }
        List<String> result = new ArrayList<>();
        while (k > 0) {
            result.add(maxHeap.poll());
            k--;
        }
        return result;
    }
}