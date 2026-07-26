class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> map = new HashMap<>();

        for (String str : strs) {
            Integer arr[] = new Integer[26];
            Arrays.fill(arr, 0);
            for(char c : str.toCharArray()) {
                arr[c - 'a']++;
            }
            List<Integer> list = Arrays.asList(arr);


            List<String> stringList = map.getOrDefault(list, new ArrayList());
            stringList.add(str);
            map.put(list, stringList);
        }

        return new ArrayList<>(map.values());
    }
}
