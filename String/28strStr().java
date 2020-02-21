class Solution {
    //find a string in another string
    public int strStr(String haystack, String needle) {
        //use substring
        if (needle.equals("")) {
            return 0;
        }
        if (haystack.length() == needle.length()) {
            if (haystack.equals(needle)) {
                return 0;
            }
        }
        int n = needle.length();
        for (int i = 0; i <= haystack.length() - n; i++) {
            String sub = haystack.substring(i, i + n);
            if (sub.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
//Or use hashcode of the string to acheive linear time complexity
