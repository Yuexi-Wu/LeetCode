class Solution {
    public int longestRepeatingSubstring(String S) {
        int n = S.length();
        int ans = 0;
        int left = 0, right = n;
        while (left <= right) {
            int mid = left + (right-left) / 2;
            if (search(mid, n, S) == -1) {
                right = mid - 1;
            } else {
                ans = Math.max(ans, search(mid, n, S));
                left = mid + 1;
            }
        }
        return ans;
    }
    
    private int search(int len, int n, String S) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n-len+1; i++) {
            String cur = S.substring(i, i+len);
            if (set.contains(cur)) {
                return len;
            }
            set.add(cur);
        }
        return -1;
    }
}
