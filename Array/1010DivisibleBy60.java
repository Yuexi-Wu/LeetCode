class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        int len = time.length;
        //Time limit exceeded
        // for (int i = 0; i < len - 1; i++) {
        //     for (int j = i + 1; j < len; j++) {
        //         if ((time[i] + time[j]) % 60 == 0) {
        //             ans++;
        //         }
        //     }
        // }
        int[] count = new int[60];
        for (int t : time) {
            ans += t % 60 == 0 ? count[0] : count[60 - t % 60];
            count[t % 60]++;
        }
        return ans;
    }
}

Using bruteforce causes time limit exceeded exception, so use a new array to count how many elements in time %60 values i.
Because of we want the number of pairs, so when we have an element in time[], we only need to check how many 60-num%60 there is and that is the number of result that involves current number.