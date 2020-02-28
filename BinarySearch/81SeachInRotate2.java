class Solution {
    public boolean search(int[] nums, int target) {
        //Since there are duplicates, we cannot use binary search.
        //The worst case could be [1, 1, 1, ..., 1] with a 0 in it, we cannot use binary search to find it.
        //Thus the time complexity is O(n) by brute force.
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
