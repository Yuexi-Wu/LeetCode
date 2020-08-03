 class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(0, 0, n*2, "", result);
        return result;
    }
    
    private void dfs(int open, int close, int len, String cur, List<String> result) {
        if (cur.length() == len) {
            result.add(cur);
            return;
        }
        if (open < len / 2) {
            dfs(open + 1, close, len, cur+"(", result);
        }
        if (close < open) {
            dfs(open, close + 1, len, cur + ")", result);
        }
    }
}
