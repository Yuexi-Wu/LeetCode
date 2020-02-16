class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int len = len1 + len2;
        int[] ans = new int[len];
        for (int i = len1 - 1; i >= 0; i--) {
            int cur1 = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int k = i + j + 1;
                int cur2 = num2.charAt(j) - '0';
                ans[k-1] += (cur1 * cur2 + ans[k]) / 10;
                ans[k] = (cur1 * cur2 + ans[k]) % 10;
                
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i : ans) {
            if (!(result.length() == 0 && i == 0)) {
                result.append(i);
            }
        }
        if (result.length() == 0) {
            return "0";
        }
        return result.toString();
    }
}
