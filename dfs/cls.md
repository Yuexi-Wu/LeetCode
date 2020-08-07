### permutation: once a letter and only once so we need 
> boolean[] visited  
> HashSet<Integer> visited 🆗  
```
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
```  
If there are `dumplicates` in nums, then we need to avoid duplications in result, to do this, we need to first sort the array and in the dfs, we check whether the number we are using is the same as the last one.
  
```
      Arrays.sort(nums);
      // in backtracking:
      for (int i = 0; i < nums.size(); i++) {
            if (i != 0 && nums.get(i) == nums.get(i-1)) {
                continue;
            }
            ...
      }
```
The way of avoiding duplications is to Elect representative.  
  

### Combination: doesn't have to be only once, so we may not need visited  
For example: combination sum  
```
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
```  
if it is K sum, find K numbers whose sum is target, so we can directly add k into our parameter list and each time k--  
