class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //sliding window
        if (k <= 1) {
            return 0;
        }
        int product = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left++];
            }
            ans += right - left + 1;
        }
        return ans;
    }
}
