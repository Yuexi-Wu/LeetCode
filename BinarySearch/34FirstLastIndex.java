class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }
    
    private int findLast(int[] nums, int target) {
        int head = 0, end = nums.length - 1;
        while (head + 1 < end) {
            int mid = head + (end - head) / 2;
            if (nums[mid] == target) {
                head = mid;
            } else if (nums[mid] < target) {
                head = mid;
            } else {
                end = mid;
            }
        }
        //end should be checked first, cuz if end is target in the first place, return it.
        //order matters!
        if (nums[end] == target) {
            return end;
        } else if (nums[head] == target) {
            return head;
        } else {
            return -1;
        }
    }
    
    private int findFirst(int[] nums, int target) {
        int head = 0, end = nums.length - 1;
        //binary search: different when we find mid == target
        while (head + 1 < end) {
            int mid = head + (end - head) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                head = mid;
            } else {
                end = mid;
            }
        }
        if (nums[head] == target) {
            return head;
        } else if (nums[end] == target) {
            return end;
        } else {
            return -1;
        }
    }
}
