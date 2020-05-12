class Solution {
    public int singleNonDuplicate(int[] nums) {
        // binary search
        int left = 0, right = nums.length-1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int left_part, right_part;
            if (nums[mid-1] == nums[mid]) {
                left_part = mid-1-left;
                if (left_part % 2 == 0) {
                    left = mid + 1;
                } else {
                    right = mid - 2; 
                }
            } else if (nums[mid] == nums[mid+1]) {
                left_part = mid - left;
                if (left_part % 2 == 0) {
                    left = mid + 2;
                } else {
                    right = mid - 1; 
                }
            } else {
                return nums[mid];
            }
        }
        return nums[left];
    }
}
