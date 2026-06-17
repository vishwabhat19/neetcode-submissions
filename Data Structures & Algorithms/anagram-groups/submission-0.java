class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for(int i=0;i<strs.length;i++) {
            String currentString = strs[i];
            char[] arr = currentString.toCharArray();
            Arrays.sort(arr);
            String sortedString = new String(arr);
            List<String> list = map.getOrDefault(sortedString, new ArrayList());
            list.add(currentString);
            map.put(sortedString, list);
        }
        return new ArrayList(map.values());
    }
}
