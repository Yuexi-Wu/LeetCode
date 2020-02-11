class Solution {
    public int mySqrt(int x) {
        //binary search
        //Base on the observation that for any interger x larger than 2, square is less than x/2.
        if (x < 2) {
            return x;
        }
        int left = 2, right = x/2;
        //not left > right
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //should be long type, cuz x may be very large
            if ((long)mid * mid > x) {
                right = mid - 1;
            } else if ((long)mid * mid < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right;
    }
}
