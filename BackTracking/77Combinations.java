class Solution {
    List<List<Integer>> result = new LinkedList<>();
    int n;
    int k;
    
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<Integer>());
        return result;
    }
    
    private void backtrack(int first, LinkedList<Integer> curr) {
        if (curr.size() == k) {
            result.add(new LinkedList(curr));
            return;
        }
        for (int i = first; i <= n; i++) {
            curr.add(i);
            backtrack(i+1, curr);
            curr.removeLast();
        }
    }
}
