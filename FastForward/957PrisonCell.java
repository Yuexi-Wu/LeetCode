class Solution {
    // fast forward: find a cycle of a certern pattern
    public int[] prisonAfterNDays(int[] cells, int N) {
        Set<String> set = new HashSet<>();
        boolean fast = false;
        int count = 0;
        for (int i = 0; i < N; i++) {
            int[] cur = nextCell(cells);
            String curstring = Arrays.toString(cur);
            if (set.contains(curstring)) {
                fast = true;
                break;
            } else {
                set.add(curstring);
                count++;
            }
            cells = cur;
        }
        if (fast) {
            N = N % count;
            while (N > 0) {
                cells = nextCell(cells);
                N--;
            }
        }
        return cells;
    }
    
    private int[] nextCell(int[] cells) {
        int[] cur = new int[cells.length];
        cur[0] = cur[cells.length-1] = 0;
        for (int i = 1; i < cells.length - 1; i++) {
            cur[i] = cells[i-1] == cells[i+1] ? 1 : 0;
        }
        return cur;
    }
}
