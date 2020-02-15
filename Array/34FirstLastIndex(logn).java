class Solution {
    
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target || (!left && nums[mid] == target)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int left = extremeInsertionIndex(nums, target, true);
        if (left == nums.length || nums[left] != target) {
            return result;
        }
        int right = extremeInsertionIndex(nums, target, false) - 1;
        result[0] = left;
        result[1] = right;
        return result;
    }
}
