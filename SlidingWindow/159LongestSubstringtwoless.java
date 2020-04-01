class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        //sliding window
        if (s.length() <= 2) {
            return s.length();
        }
        int left = 0, ans = 0, sum = 0;
        for (int right = 1; right < s.length(); right++) {
            String cur = s.substring(left, right+1);
            while (count(cur) > 2) {
                left++;
                cur = s.substring(left, right+1);
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
    
    private int count(String s) {
        Set<Character> set = new HashSet<>();
        for (char c: s.toCharArray()) {
            set.add(c);
        }
        return set.size();
    }
}
