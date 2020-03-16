public class Solution {
    /**
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return -1;
        }
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int dif = Integer.MAX_VALUE;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                dif = Math.min(dif, Math.abs(sum - target));
                left++;
            } else if (sum > target) {
                dif = Math.min(dif, Math.abs(sum - target));
                right--;
            } else {
                return 0;
            }
        }
        return dif;
    }
}
