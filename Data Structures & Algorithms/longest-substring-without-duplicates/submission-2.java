class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int right =0;right<s.length();right++) {
            char c = s.charAt(right);

            if (map.containsKey(c) && map.get(c) >= left) {
                //This means the character found at right is already present in the
                //current substring and hence left needs to be adjusted
                //We find the last occurence of c
                left = map.get(c) + 1; //so we are just moving left to the right
            }

            map.put(c, right);

            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
