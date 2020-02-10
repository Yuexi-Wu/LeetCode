class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int n = num1.length() - 1;
        int m = num2.length() - 1;
        int carry = 0;
        while (n >= 0 || m >= 0) {
            int sum = carry;
            if (n >= 0) {
                sum += num1.charAt(n--) - '0';
            }
            if (m >= 0) {
                sum += num2.charAt(m--) - '0';
            }
            sb.append(sum % 10);
            carry = sum / 10;
        }
        if (carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
