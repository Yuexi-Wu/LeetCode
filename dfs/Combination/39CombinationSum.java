class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    // to avoid replication like [[2,2,3],[2,3,2],[3,2,2],[7]], we need a start
    private void dfs(int[] candidates, int target, int start, List<Integer> cur, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            cur.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, cur, result);
            cur.remove(cur.size() - 1);
        }
        
    }
}
