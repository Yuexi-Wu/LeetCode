// Regex solution
class Solution {
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]*|.[a-z]*");
        // [A-Z]* means any letter between A-Z repeat * times
    }
}

// Normal solution
class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.equals("") || word == null) {
            return false;
        }
        char first = word.charAt(0);
        if (Character.isUpperCase(first)) {
            if (allUpper(word) || allLower(word.substring(1, word.length()))) {
                return true;
            }
        } else {
            if (allLower(word)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean allLower(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(i))) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    
    private boolean allUpper(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
