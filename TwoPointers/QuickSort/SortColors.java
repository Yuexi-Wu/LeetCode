class Solution {
    public void sortColors(int[] nums) {
        int lastpos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(lastpos++, i, nums);
            }
        }
        if (lastpos == nums.length) {
            return;
        }
        for (int i = lastpos; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(lastpos++, i, nums);
            }
        }
        if (lastpos == nums.length) {
            return;
        }
        for (int i = lastpos; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(lastpos++, i, nums);
            }
        }
    }
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
 // Arrays.sort(nums);
