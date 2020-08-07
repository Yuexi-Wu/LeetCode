class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        dfs(nums, nums.length, visited, new ArrayList<>(), result);
        return result;
    }
    
    private void dfs(int[] nums, int n, Set<Integer> visited, List<Integer> cur, List<List<Integer>> result) {
        if (cur.size() == n) {
            result.add(new ArrayList<>(cur));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited.contains(nums[i])) {
                cur.add(nums[i]);
                visited.add(nums[i]);
                dfs(nums, n, visited, cur, result);
                cur.remove(cur.size() - 1);
                visited.remove(nums[i]);
            }
            
        }
    }
}
