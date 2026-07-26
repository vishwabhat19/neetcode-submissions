class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int i=0;i<t.length();i++) {
            char c = t.charAt(i);
            if (sMap.containsKey(c) && sMap.get(c) > 0) {
                int val = sMap.get(c) - 1;
                sMap.put(c, val);
            }
            else {
                return false;
            }
        }
        return true;
    }
}
