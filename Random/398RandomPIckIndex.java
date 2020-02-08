class Solution {

    int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                set.add(i);
            }
        }
        Random r = new Random();
        Object[] ans = set.toArray();
        return (int)ans[r.nextInt(ans.length)];
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
