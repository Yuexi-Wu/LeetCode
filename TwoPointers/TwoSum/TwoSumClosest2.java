public class Solution {
    /**
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
     
    int dif = Integer.MAX_VALUE;
    int target = 0;
    
    public int twoSumClosest(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return -1;
        }
        this.target = target;
        Arrays.sort(nums);
        int right = nums.length - 1;
        for (int left = 0; left < nums.length; left++) {
            while (right >= 0 && nums[left] + nums[right] >= target) {
                right--;
            }
            update(left, right, nums);
            update(left, right - 1, nums);
            update(left, right + 1, nums);
        }
        return dif;
    }
    
    public void update(int left, int right, int[] nums) {
        if (left != right && left >= 0 && left < nums.length && right >= 0 && right < nums.length) {
            dif = Math.min(dif, Math.abs(nums[left] + nums[right] - target));
        }
    }
}
