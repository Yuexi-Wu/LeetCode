/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        if (graph == null || graph.size() == 0) {
            return res;
        } 
        Map<DirectedGraphNode, Integer> map = new HashMap<>();
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                map.put(neighbor, map.getOrDefault(neighbor, 0) + 1);
            }
        }
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                queue.offer(node);
                res.add(node);
            }
        }
        while (!queue.isEmpty()) {
            DirectedGraphNode curNode = queue.poll();
            for (DirectedGraphNode nodes : curNode.neighbors) {
                map.put(nodes, map.get(nodes) - 1);
                if (map.get(nodes) == 0) {
                    queue.offer(nodes);
                    res.add(nodes);
                }
            }
        }
        return res;
    }
}
