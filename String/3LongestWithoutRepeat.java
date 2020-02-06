//BF
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int len = s.length();
        int ans = 1;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i+1; j < len; j++) {
                if (!checkRepeat(i, j, s)) {
                    ans = Math.max(ans, j-i+1);
                }
            }
        }
        return ans;
    }
    private boolean checkRepeat(int start, int end, String s) {
        HashSet<Character> set = new HashSet<>();
        char[] chars = s.substring(start, end + 1).toCharArray();
        for (char character : chars) {
            if (set.contains(character)) {
                return true;
            }
            set.add(character);
        }
        return false;
    }
}

//Sliding Window
Unlike brute force, sliding window figures that if there is no repetition between (slow, fast), 
and repetition starts from (slow, fast+1), there is no repetition between(slow+1, fast), so we 
just slide the window and keep tracking.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        int len = s.length();
        int ans = 1;
        int slow = 0, fast = 0;
        while (slow < len && fast < len) {
            if (!set.contains(s.charAt(fast))) {
                set.add(s.charAt(fast++));
                ans = Math.max(ans, fast-slow);
            } else {
                set.remove(s.charAt(slow++));
            }
        }
        return ans;
    }
}
