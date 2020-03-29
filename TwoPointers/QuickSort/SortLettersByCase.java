public class Solution {
    /*
     * Given a string which contains only letters. Sort it by lower case first and upper case second.
     * @param chars: The letter array you should sort by Case
     * @return: nothing
     */
    public void sortLetters(char[] chars) {
        // write your code here
        int left = 0, right = chars.length-1;
        while (left < right) {
            while(left < right && Character.isLowerCase(chars[left])) {
                left++;
            }
            while(left < right && Character.isUpperCase(chars[right])) {
                right--;
            }
            if (left >= chars.length-1 || right <= 0) {
                return;
            }
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
        }
    }
}
