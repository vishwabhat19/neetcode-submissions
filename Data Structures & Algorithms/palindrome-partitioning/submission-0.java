class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partition(s, result, new ArrayList(), 0);
        return result;
    }

    void partition(String s, List<List<String>> result, List<String> tempList, int currentIndex) {
        if (currentIndex == s.length()) {
            result.add(new ArrayList(tempList));
            return;
        }

        for(int i=currentIndex;i<s.length();i++) {
            String substring = s.substring(currentIndex, i+1);
            if (!isPalindrome(substring)) continue;
            tempList.add(substring);
            partition(s, result, tempList, i+1);
            tempList.remove(tempList.size() - 1);
        }
    }

    boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return false;
        if (s.length() == 1) return true;
        int left = 0;
        int right = s.length() -1;
        while(left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
