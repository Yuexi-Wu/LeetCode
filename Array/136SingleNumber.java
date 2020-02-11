class Solution {
    public int singleNumber(int[] nums) {
        int n = (nums.length + 1) / 2;
        Set<Integer> set = new HashSet<>(n);
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        for (int i : set) {
            return i;
        }
        return -1;
    }
}
