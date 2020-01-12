/**
    Two brute force approaches, result : time limit exceeded.
**/
    public boolean word_break(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_break(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }

    public boolean word_break(String s, List<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (String word : wordDict) {
            System.out.println("current word:" + word);
            int len = word.length();
            int end = start + len;
            if (end > s.length()) {
                continue;
            }
            if (word.equals(s.substring(start, end))) {
                System.out.println("substring:" + s.substring(start, end));
                if (word_break(s, wordDict, end)) {
                    return true;
                }
            }
        }
        return false;
    }

/**
    Use memoization: store whether the substring starts at "start" can be splitted in a boolean array.
**/
    public boolean word_break(String s, List<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        for (String word : wordDict) {
            System.out.println("current word:" + word);
            int len = word.length();
            int end = start + len;
            if (memo[start] != null) {
                return memo[start];
            }
            if (end > s.length()) {
                continue;
            } 
            if (word.equals(s.substring(start, end))) {
                System.out.println("substring:" + s.substring(start, end));
                if (word_break(s, wordDict, end, memo)) {
                    memo[start] = true;
                    return true;
                }
            } 
        }
        memo[start] = false;
        return false;
    }

/**
    Using BFS.
**/
    public boolean wordBreak(String s, List<String> wordDict) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDict.contains(s.substring(start, end))) {
                        queue.add(end);
                        
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }

/**
    Dynamic Programming.
**/
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length() + 1; j++) {
                if (dp[i] && wordDict.contains(s.substring(i, j))) {
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }