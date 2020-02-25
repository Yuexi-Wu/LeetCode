class Solution {
    //topological sort
    public String alienOrder(String[] words) {
        //put the characters after the character into a set
        Map<Character, Set<Character>> graph = constructGraph(words);
        return topologicalSorting(graph);
    }
    
    private Map<Character, Set<Character>> constructGraph(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        //create nodes:
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!graph.containsKey(c)) {
                    graph.put(c, new HashSet<>());
                }
            }
        }
        //create edges:
        for (int i = 0; i < words.length - 1; i++) {
            int index = 0;
            while (index < words[i].length() && index < words[i+1].length()) {
                if (words[i].charAt(index) != words[i+1].charAt(index)) {
                    graph.get(words[i].charAt(index)).add(words[i+1].charAt(index));
                    //This break guarantees that the two nodes on the edges are the first different chars in two words, so that can be sorted.
                    break;
                }
                index++;
            }
        }
        return graph;
    }
    
    private Map<Character, Integer> getInDegree(Map<Character, Set<Character>> graph) {
        Map<Character, Integer> indegree = new HashMap<>();
        //make sure every character is in indegree map
        //also for the comparison last step
        for (Character c : graph.keySet()) {
            indegree.put(c, 0);
        }
        for (Character c : graph.keySet()) {
            for (Character follow : graph.get(c)) {
                indegree.put(follow, indegree.get(follow) + 1);
            }
        }
        return indegree;
    }
    
    private String topologicalSorting(Map<Character, Set<Character>> graph) {
        Map<Character, Integer> indegree = getInDegree(graph);
        Queue<Character> queue = new LinkedList<>();
        for (Character c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            char cur = queue.poll();
            builder.append(cur);
            Set<Character> follows = graph.get(cur);
            for (char c : follows) {
                indegree.put(c, indegree.get(c) - 1);
                if (indegree.get(c) == 0) {
                    queue.offer(c);
                }
            }
        }
        if (builder.length() != indegree.size()) {
            return "";
        }
        return builder.toString();
    }
}
