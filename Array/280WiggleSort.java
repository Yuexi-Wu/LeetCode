class Solution {
    public void wiggleSort(int[] nums) {
        // Solution1: sort and wiggle
        // Arrays.sort(nums);
        // for (int i = 1; i < nums.length-1; i+=2) {
        //     int temp = nums[i];
        //     nums[i] = nums[i+1];
        //     nums[i+1] = temp;
        // }
        // Solution2: wiggle by position
        for (int i = 1; i < nums.length; i++) {
            if (i%2 == 0 && nums[i] > nums[i-1]) {
                swap(nums, i, i-1);
            }
            if (i%2 == 1 && nums[i] < nums[i-1]) {
                swap(nums, i, i-1);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
