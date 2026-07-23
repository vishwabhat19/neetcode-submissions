class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);

            if (c == '(') {
                leftStack.push(i);
            }
            else if (c == '*') {
                starStack.push(i);
            }
            else {
                if (!leftStack.isEmpty()) leftStack.pop();
                else if (!starStack.isEmpty()) starStack.pop();
                else return false;
            }
        }

        while(!leftStack.isEmpty()) {
            if (starStack.isEmpty()) return false;
            int leftIndex = leftStack.pop();
            int starIndex = starStack.pop();
            if (starIndex < leftIndex) return false;
        }
        return true;
    }
}
