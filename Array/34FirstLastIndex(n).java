class Solution {
    //if O(n) time complexity: do linear search.
    public int[] searchRange(int[] nums, int target) {
        //find first index: search from start (0)
        //find last index: seach from tail(nums.length - 1)
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result[0] = i;
                break;
            }
        }
        //if we haven't find the first index, return the result, no need to search from tail.
        if (nums[0] == -1) {
            return result;
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] == target) {
                result[1] = j;
                break;
            }
        }
        return result;
    }
}
