class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            map.put(s.charAt(i), i);
        }

        int start = 0;
        int end = 0;

        for(int i=0;i<s.length();i++) {
            end = Math.max(map.get(s.charAt(i)), end);
            if (end == i) {
                int length = end - start + 1;
                result.add(length);
                start = i + 1;
            }
        }
        
        return result;
    }
}
