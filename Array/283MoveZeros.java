class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        //firstZero keeps the first zero in the array
        int firstZero = 0;
        
        for (int i = 0; i < nums.length; i++) {
            //only update firstZero when the element is not zero
            if (nums[i] != 0) {
                int temp = nums[zero];
                nums[zero] = nums[i];
                nums[i] = temp;
                zero++;
            }
            
        }
    }
}