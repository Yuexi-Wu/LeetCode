class Solution {
    public int findMin(int[] nums) {
        // binary search
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                if (nums[mid] > nums[nums.length - 1]) {
                    left = mid;
                } else {
                    right = mid;
                }
            } else {
                return nums[mid + 1];
            }
        }
        if (nums[left] > nums[right]) {
            return nums[right];
        } else if (nums[left] < nums[right]){
            return nums[left];
        }
        return -1;
    }
}
