class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> needMap = new HashMap();
        Map<Character, Integer> haveMap = new HashMap();
        int left = 0;
        int right = 0;
        int length = Integer.MAX_VALUE;
        String result = "";

        for(int i=0;i<t.length();i++) {
            needMap.put(t.charAt(i), needMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        for(Character c : needMap.keySet()) {
            haveMap.put(c, 0);
        }

        int haveValue = 0;
        int needValue = needMap.size();

        while(right < s.length()) {
            char c = s.charAt(right);

            if (needMap.containsKey(c)) {
                haveMap.put(c, haveMap.getOrDefault(c, 0) + 1);
                if (haveMap.get(c).equals(needMap.get(c))) {
                    haveValue++;
                }
            }

            while (haveValue == needValue) {
                String tempString = s.substring(left, right + 1);
                int tempLength = tempString.length();
                if (tempLength < length) {
                    length = tempLength;
                    result = tempString;
                }

                char tempChar = s.charAt(left);

                if (needMap.containsKey(tempChar) && needMap.get(tempChar).equals(haveMap.get(tempChar))) {
                    haveValue--;
                }

                if (haveMap.containsKey(tempChar)) {
                    haveMap.put(tempChar, haveMap.getOrDefault(tempChar, 0) - 1);
                }

                left++;
            }

            right++;
        }

        return result;


    }
}
