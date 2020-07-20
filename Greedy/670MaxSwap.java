class Solution {
    public int maximumSwap(int num) {
        // greedy
        // swap with the largest number behind it.
        char[] nums = Integer.toString(num).toCharArray();
        
        int[] last = new int[10];
        for (int i = 0; i < nums.length; i++) {
            last[nums[i] - '0'] = i;
        }
        for (int i = 0; i < nums.length; i++) {
            // no need to iterate to digit >= 0
            for (int digit = 9; digit > nums[i] - '0'; digit--) {
                if (last[digit] > i) {
                    char temp = nums[last[digit]];
                    nums[last[digit]] = nums[i];
                    nums[i] = temp;
                    return Integer.valueOf(new String(nums));
                }
            }
        }
        return num;
    }
}
