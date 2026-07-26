class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] carr = str.toCharArray();
            Arrays.sort(carr);
            String sortedString = new String(carr);
            List<String> list = map.getOrDefault(sortedString, new ArrayList());
            list.add(str);
            map.put(sortedString, list);
        }
        return new ArrayList(map.values());
    }
}
