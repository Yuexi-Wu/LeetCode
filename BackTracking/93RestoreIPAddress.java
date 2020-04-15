class Solution {
    int n;
    String s;
    LinkedList<String> segments = new LinkedList<>();
    ArrayList<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        this.s = s;
        backtracking(-1, 3);
        return result;
    }
    
    private boolean valid(String segment) {
        int m = segment.length();
        if (m > 3) {
            return false;
        }
        if (segment.charAt(0) == '0') {
            return m == 1;
        } else {
            return Integer.valueOf(segment) <= 255;
        }
    }
    
    private void update(int cur) {
        String segment = s.substring(cur + 1, n);
        if (valid(segment)) {
            segments.add(segment);
            result.add(String.join(".", segments));
            segments.removeLast();
        }
    }
    
    private void backtracking(int prev, int dots) {
        int max_pos = Math.min(n-1, prev + 4);
        for (int cur = prev+1; cur < max_pos; cur++) {
            String segment = s.substring(prev + 1, cur + 1);
            if (valid(segment)) {
                segments.add(segment);
                if (dots == 1) {
                    update(cur);
                } else {
                    backtracking(cur, dots - 1);
                }
                segments.removeLast();
            }
        }
    }
}
