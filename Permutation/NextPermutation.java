/**
* There must exits a continuous decending array in the permutation, find its start.
* find the least number larger than the number before the array, swap them and reverse the array
*/
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i+1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = n-1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(i, j, nums);
        }
        reverse(i+1, n-1, nums);
    }
    
    private void reverse(int i, int j, int[] nums) {
        while (i < j) {
            swap(i++, j--, nums);
        }
    }
    
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}
