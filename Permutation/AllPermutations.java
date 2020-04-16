class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int n;
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        ArrayList<Integer> nums_list = new ArrayList<>();
        for (int num : nums) {
            nums_list.add(num);
        }
        backtracking(0, nums_list);
        return result;
    }
    
    private void backtracking(int first, ArrayList<Integer> nums) {
        if (first == n) {
            result.add(new ArrayList<Integer>(nums));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(nums, first, i);
            backtracking(first+1, nums);
            Collections.swap(nums, first, i);
        }
    }
}
