class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] characters = str.toCharArray();
            Arrays.sort(characters);
            String key = String.valueOf(characters);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
                
            } 
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}


//Use a hashmap to record the sorted string and an arraylist of anagrams of it.
