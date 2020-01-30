class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for (int num : nums) {
            count[num] += num;
        }
        int take_pre = 0, skip_pre = 0;
        for (int i = 1; i <= 10000; i++) {
            int take_cur = skip_pre + count[i];
            int skip_cur = Math.max(take_pre, skip_pre);
            take_pre = take_cur;
            skip_pre = skip_cur;
        }
        return Math.max(take_pre, skip_pre);
    }
}

This is a dynamic programming question and it is really similar to House Robber. Both of them restrict that
we cannot take two next to each other.
take_pre is if we take the delete the previous number in count[].(previous is 1 less than current)
skip_pre is if we didn't take the previous number.