class Solution {
    public int hammingDistance(int x, int y) {
        int dif = x ^ y;
        int ans = 0;
        while (dif != 0) {
            if (dif % 2 == 1) {
                ans++;
            }
            dif = dif >> 1;
        }
        return ans;
    }
}

// or
class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y); 
    }
}
