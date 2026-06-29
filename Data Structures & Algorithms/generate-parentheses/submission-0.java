class Solution {
    public List<String> generateParenthesis(int n) {
        int l = 0;
        int r = 0;
        List<String> result = new ArrayList();
        generate(n, result, l, r, "");
        return result;
    }

    void generate(int n, List<String> result, int l, int r, String currentString) {
        if (l == n && l == r) {
            result.add(currentString);
            return;
        }

        if (l < n) {
            generate(n, result, l+1, r, currentString + "(");
        }

        if (r < l) {
            generate(n, result, l, r+1, currentString + ")");
        }
    }
}
