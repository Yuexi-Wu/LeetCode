class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //bfs --queue, map
        //because set has a fast retreival at an unknown location
        Set<String> wordSet = new HashSet<>();
        for (String word : wordList) {
            wordSet.add(word);
        }
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                char[] cur_char = cur.toCharArray();
                for (int j = 0; j < cur_char.length; j++) {
                    char origin = cur_char[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (origin == c) {
                            continue;
                        }
                        cur_char[j] = c;
                        String new_word = String.valueOf(cur_char);
                        if (new_word.equals(endWord)) {
                            return level+1;
                        }
                        if (wordSet.contains(new_word)) {
                            queue.offer(new_word);
                            wordSet.remove(new_word);
                        }
                    }
                    cur_char[j] = origin;
                }
                
            }
            level++;
        }
        return 0;
    }
}
