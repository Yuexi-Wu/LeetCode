class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        // right shift until m = n, which returns the common bit(prefix), then left shift that much.
        int shift = 0;
        while (m < n) {
            m = m >> 1;
            n = n >> 1;
            shift++;
        }
        return m << shift;
    }
}
