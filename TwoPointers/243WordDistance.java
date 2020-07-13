class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        // List<Integer> index1 = new ArrayList<>();
        // List<Integer> index2 = new ArrayList<>();
        // for (int i = 0; i < words.length; i++) {
        //     if (words[i].equals(word1)) {
        //         index1.add(i);
        //     }
        //     if (words[i].equals(word2)) {
        //         index2.add(i);
        //     }
        // }
        // int min = Integer.MAX_VALUE;
        // for (int i : index1) {
        //     for (int j : index2) {
        //         min = Math.min(min, Math.abs(j - i));
        //     }
        // }
        // return min;
        
        int min = words.length;
        int index1 = -1, index2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
            }
            if (words[i].equals(word2)) {
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                min = Math.min(min, Math.abs(index2 - index1));
            }
        }
        return min;
    }
}
