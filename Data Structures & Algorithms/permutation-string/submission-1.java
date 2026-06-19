class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] freq1 = new int[26];
        int n = s1.length();
        for(int i=0;i<n;i++) {
            freq1[s1.charAt(i) - 'a']++;
        }
        int left = 0;
        int right = n-1;
        while(right < s2.length()) {
            String currentWindow = s2.substring(left, right+1);
            boolean found = true;
            int[] freq2 = new int[26];
            for(int i=left;i<=right;i++) {
                freq2[s2.charAt(i) - 'a']++;
            }

            //compare freq1 and freq2
            for(int i=0;i<26;i++) {
                if (freq1[i]!=freq2[i]) {
                    found = false;
                    break;
                }
            }

            if (found) return true;
            else {
                left++;
                right++;
            }

        }

        return false;

    }
}
