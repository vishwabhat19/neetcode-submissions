class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedString = new String(arr);
            if (map.containsKey(sortedString)) {
                List<String> list = map.get(sortedString);
                list.add(str);
                map.put(sortedString, list);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortedString, list);
            }
        }

        return new ArrayList(map.values());
    }
}
