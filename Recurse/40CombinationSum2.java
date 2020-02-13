class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    Arrays.sort(candidates);
    boolean[] visited = new boolean[candidates.length];
    helper(candidates, 0, target, 0, temp, result, visited);
    return result;
}
 
private void helper(int[] candidates, int start, int target, int sum,
                    List<Integer> list, List<List<Integer>> result, boolean[] visited){
    if(sum>target){
        return;
    }
 
    if(sum==target){
        result.add(new ArrayList<>(list));
        return;
    }
 
    for(int i=start; i<candidates.length; i++){
        if (!visited[i]) {
            if(i>0 && candidates[i] == candidates[i-1] && visited[i-1] == false) {
                continue; 
            }
            list.add(candidates[i]);
            visited[i] = true;
            helper(candidates, i + 1, target, sum+candidates[i], list, result, visited);
            visited[i] = false;
            list.remove(list.size()-1);
        }
    }
    //or
    int prev = -1;
    for(int i=start; i<candidates.length; i++){
        if(prev == candidates[i]) {
            continue; 
        }
        list.add(candidates[i]);
        visited[i] = true;
        helper(candidates, i + 1, target, sum+candidates[i], list, result, visited);
        prev = candidates[i];
        list.remove(list.size()-1);
    }
}
}
