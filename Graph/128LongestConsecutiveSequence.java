class Solution {
    //Use hashset delete duplication.
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 0;
        //Although there is a while loop in for loop, the time complexity is still O(n), 
        //because the while loop can only iterate for n times, the if condition reduces duplication of the chance of run while on the same element. 
        for (int num : set) {
            //Important if condition: reduces time complexity:↓
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentResult = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentResult++;
                }
                result = Math.max(result, currentResult);
            }
        }
        return result;
    }
}