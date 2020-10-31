public class Solution {
    /**
     * @param nums: a integer array
     * @return: return an integer denoting the number of non-unique(duplicate) values
     */
    public List<Integer> CountDuplicates(List<Integer> nums) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                if (map.get(num) == 1) {
                    ans.add(num);
                }
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        return ans;
    }
    
}
