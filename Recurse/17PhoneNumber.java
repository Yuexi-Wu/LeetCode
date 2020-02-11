class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        String[] mapping = new String[]{
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        recurse(digits, ans, 0, "", mapping);
        return ans;
    }
    private void recurse(String digits, List<String> ans, int index, String cur, String[] mapping) {
        if (index == digits.length()) {
            ans.add(cur);
            return;
        }
        String letters = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            recurse(digits, ans, index + 1, cur+letters.charAt(i), mapping);
        }
    }
}
