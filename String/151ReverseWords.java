class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        int left = 0, right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(words[0]);
        for (int i = 1; i < words.length; i++) {
            sb.append(' ');
            sb.append(words[i]);
        }
        return sb.toString();
    }
}
