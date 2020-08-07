class Solution {
    int sum = 0;
    public int countArrangement(int N) {
        Set<Integer> visited = new HashSet<>();
        backtracking(1, N, new ArrayList<>(), visited);
        return sum;
    }
    
    private void backtracking(int index, int N, List<Integer> cur, Set<Integer> visited) {
        if (cur.size() == N) {
            sum++;
        }
        
        for (int i = 1; i <= N; i++) {
            if ((i % index == 0 || index % i == 0) && !visited.contains(i)) {
                cur.add(i);
                visited.add(i);
                backtracking(index + 1, N, cur, visited);
                visited.remove(i);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
