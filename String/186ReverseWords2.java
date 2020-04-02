class Solution {
    // 1.reverse array
    // 2.reverse each word
    public void reverseWords(char[] s) {
        reverse(0, s.length - 1, s);
        int left = 0, right = 0;
        while (right < s.length && left < s.length) {
            while (right < s.length && s[right] != ' ') {
                right++;
            }
            reverse(left, right-1, s);
            left = right;
            while (left < s.length && s[left] == ' ') {
                left++;
                right++;
            }
        }
    }
    
    private void reverse(int i, int j, char[] s) {
        int left = i, right = j;
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}
