class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int pivot = find_index(0, nums.length - 1, nums);
        
        if (nums[pivot] == target) {
            return pivot;
        }
        if (pivot == 0) {
            return search(0, nums.length - 1, nums, target);
        }
        if (target < nums[0]) {
            return search(pivot, nums.length - 1, nums, target);
        }
        return search(0, pivot, nums, target);
    }
    
    //find pivot
    private int find_index(int left, int right, int[] nums) {
        if (nums[left] < nums[right]) {
            return 0;
        }
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1]) {
                return pivot + 1;
            }
            else {
                if (nums[pivot] < nums[left]){
                    right = pivot - 1;
                } else {
                    left = pivot + 1;
                }
            }
        }
        return 0;
    }
    
    //after found the pivot, binary search in the appropriate part.
    private int search(int left, int right, int[] nums, int target) {
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            } 
            else if (nums[middle] < target) {
                left = middle + 1;
            } 
            else if (nums[middle] > target) {
                right = middle - 1;
            }
        }
        return -1;
    }
}
