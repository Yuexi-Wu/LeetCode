/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        //binary search
        int left = 0, right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (!isBadVersion(left) && isBadVersion(right)) {
            return right;
        } else if (isBadVersion(left)) {
            return left;
        }
        return -1;
    }
}
