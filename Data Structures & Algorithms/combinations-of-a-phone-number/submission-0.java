class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        String phone[] = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        generate(result, digits, phone, 0, "");
        return result;
    }

    void generate(List<String> result, String digits, String phone[], int index, String currentString) {
        if (currentString.length() == digits.length()) {
            result.add(currentString);
            return;
        }

        int phoneNumber = digits.charAt(index) - '0';

        String phoneString = phone[phoneNumber];

        for(char c : phoneString.toCharArray()) {
            generate(result, digits, phone, index + 1, currentString + c);
        }
    }
}
