public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int ans = 0;
        while(left < right) {
            if (nums[left] + nums[right] <= target) {
                left++;
            } else {
                ans += right - left;
                right--;
            }
        }
        return ans;
    }
}
