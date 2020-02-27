class Solution {
    public double myPow(double x, int n) {
        boolean neg = false;
        if (n < 0) {
            x = 1 / x;
            neg = true;
            //in case that n is −2^31
            n = -(n + 1);
        }
        double ans = 1;
        double temp = x;
        while (n != 0) {
            if (n % 2 == 1) {
                ans *= temp;
            }
            temp *= temp;
            n = n / 2;
        }
        if (neg) {
            ans *= x;
        }
        return ans;
    }
}
