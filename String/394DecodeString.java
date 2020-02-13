class Solution {
    public String decodeString(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<StringBuilder> strings = new Stack<>();
        int index = 0;
        StringBuilder sb = new StringBuilder();
        int cur_num = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                //in case of the number is not single digit
                cur_num = cur_num * 10 + (c - '0');
            } else if (Character.isLetter(c)) {
                //current characters in []
                sb.append(c);
            } else if (c == '[') {
                //push the number and the chars before it. As in the second example, push 'a' into strings and push 2 into nums.
                num.push(cur_num);
                cur_num = 0;
                strings.push(sb);
                sb = new StringBuilder();
            } else if (c == ']') {
                int number = num.pop();
                StringBuilder cur_result = strings.pop();
                for (int i = 0; i < number; i++) {
                    cur_result.append(sb);
                }
                sb = cur_result;
            }
            index++;
        }
        return sb.toString();
    }
}
