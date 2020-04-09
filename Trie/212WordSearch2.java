class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    String word = "";
}

class Solution {
    char[][] board = null;
    ArrayList<String> result = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);
                if (node.children.containsKey(cur)) {
                    node = node.children.get(cur);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(cur, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children.containsKey(board[i][j])) {
                    backtracking(i, j, root);
                }
            }
        }
        return this.result;
    }
    
    private void backtracking(int i, int j, TrieNode parent) {
        char temp = board[i][j];
        TrieNode curNode = parent.children.get(temp);
        
        if(curNode.word != "") {
            result.add(curNode.word);
            curNode.word = "";
        }
        
        int[] row_offset = new int[]{-1, 0, 1, 0};
        int[] col_offset = new int[]{0, -1, 0, 1};
        board[i][j] = '#';
        for (int k = 0; k < 4; k++) {
            int newrow = i + row_offset[k];
            int newcol = j + col_offset[k];
            if (newrow < 0 || newrow >= board.length || newcol < 0 || newcol >= board[0].length) {
                continue;
            }
            if (curNode.children.containsKey(board[newrow][newcol])) {
                backtracking(newrow, newcol, curNode);
            }
            
        }
        board[i][j] = temp;
        
        if (curNode.children.isEmpty()) {
            parent.children.remove(temp);
        }
    }
}
