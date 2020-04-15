class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int n, k;
    
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        // k is subset size
        for (int k = 0; k <= n; k++) {
            this.k = k;
            backtracking(0, new ArrayList<Integer>(), nums);
        }
        
        return result;
    }
    private void backtracking(int first, ArrayList<Integer> curr, int[] nums) {
        if (curr.size() == k) {
            result.add(new ArrayList(curr));
        }
        for (int i = first; i < n; i++) {
            curr.add(nums[i]);
            backtracking(i+1, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }
}
