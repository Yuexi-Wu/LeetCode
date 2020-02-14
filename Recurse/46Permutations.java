class Solution {
    //backtracking
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        helper(list, 0, result);
        return result;
    }
    
    private void helper(List<Integer> nums, int index, List<List<Integer>> result) {
        //Not creating empty arraylist and insert elements, use the current nums arraylist and swap.
        //index is actually the positions in the list, and for each i, swap first with i, for example, when index = 0, means for each i after 0, swap with it, so that's when each element to be the first one in the list.
        if (index == nums.size()) {
            result.add(new ArrayList<>(nums));
        }
        //typical backtracking: do some operation, recurse, and do something counteract the operation before. (like add -- remove || swap --- swap).
        for (int i = index; i < nums.size(); i++) {
            Collections.swap(nums, index, i);
            helper(nums, index + 1, result);
            Collections.swap(nums, index, i);
        }
    }
}
