class Solution {
    public String removeKdigits(String num, int k) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            int cur = num.charAt(i) - '0';
            while (stack.size() > 0 && k > 0 && cur < stack.peekLast()) {
                stack.removeLast();
                k--;
            }
            stack.add(cur);
        }
        for (int j = 0; j < k; j++) {
            stack.removeLast();
        }
        StringBuilder sb = new StringBuilder();
        boolean leading = true;
        for (int cur : stack) {
            if (leading && cur == 0) {
                continue;
            }
            sb.append(Character.forDigit(cur, 10));
            leading = false;
        }
        return sb.length() != 0 ? sb.toString() : "0";
    }
}
