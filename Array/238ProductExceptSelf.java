class Solution {
    //We can simply take the product of all the elements in the given array and then, for each of the elements xx of the array, we can simply find product of array except self value by dividing the product by x.----but not appliable....
    public int[] productExceptSelf(int[] nums) {
        
        int[] products = new int[nums.length];
        //left & right:accumalative product list
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i-1] * nums[i-1];
            
        }
        right[nums.length-1] = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }
        
        for(int i = 0; i < nums.length; i++) {
            products[i] = left[i] * right[i];
        }
        
        return products;
    }
}
