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


class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        //Since each element can only exist once in a permutation, we use a boolean array to keep record.
        boolean[] used = new boolean[nums.length];
        helper(list, 0, result, new ArrayList<>(), used);
        return result;
    }
    
    private void helper(List<Integer> nums, int index, List<List<Integer>> result, List<Integer> cur, boolean[] used) {
        if (cur.size() == nums.size()) {
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                cur.add(nums.get(i));
                helper(nums, index + 1, result, cur, used);
                cur.remove(cur.size() - 1);
                used[i] = false;
            }
            
        }
    }
}
