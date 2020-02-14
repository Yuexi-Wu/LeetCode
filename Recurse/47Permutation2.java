class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        helper(list, 0, result);
        return result;
    }
    
    private void helper(List<Integer> nums, int index, List<List<Integer>> result) {
        if (index == nums.size()) {
            result.add(new ArrayList<>(nums));
        }
        //Use set to constraint that it the same element as index i, no need to swap it with index for another time.
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.size(); i++) {
            if (set.contains(nums.get(i))) {
                continue;
            }
            Collections.swap(nums, index, i);
            helper(nums, index + 1, result);
            Collections.swap(nums, index, i);
            set.add(nums.get(i));
        }
    }
}
