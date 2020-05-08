class Solution {
    public int firstMissingPositive(int[] nums) {
        // if there is no 1s, just return one.
        boolean flag = false;
        for (int num : nums) {
            if (num == 1) {
                flag = true;
            }
        }
        int ans = 1;
        if (flag) {
            // if length = 1, return this + 1
            if (nums.length == 1) {
                return nums[0] + 1;
            }
            // since the first missing positive cannot be larger than the length of the array or negative, we change them to 1s
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= 0 || nums[i] > nums.length) {
                    nums[i] = 1;
                }
            }
            // since we want to do this in-space, we mark we had this number by marking the index change the number on this index to -num.
            for (int i = 0; i < nums.length; i++) {
                int index = nums[i] > 0 ? nums[i] : nums[i]*(-1);
                // if the length is included in the array, we mark to 0 for later
                if (index == nums.length) {
                    nums[0] = nums[0] * -1;
                } else {
                    nums[index] = nums[index] < 0 ? nums[index] : -nums[index];
                }
            }
            // thus (the first positive in the array)'s index is our result
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > 0) {
                    return i;
                }
            }
            if (nums[0] > 0) {
                return nums.length;
                // else : there length is in the array since we had marked 0, so return +1
            } else {
                return nums.length+1;
            }
        }
        return ans;
    }
}
