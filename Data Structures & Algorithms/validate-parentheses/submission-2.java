class Solution {
    public boolean isValid(String s) {
        if (s.length() <= 1) return false;
        Deque<Character> deque = new ArrayDeque();
        for(int i=0;i<s.length();i++) {
            Character bracket = s.charAt(i);
            if (bracket.equals('(') || bracket.equals('[') || bracket.equals('{')) {
                deque.push(bracket);
            }
            else if (bracket.equals(')') && !deque.isEmpty() && deque.peekFirst().equals('(')) {
                deque.pop();
            }
            else if (bracket.equals(']') && !deque.isEmpty() && deque.peekFirst().equals('[')) {
                deque.pop();
            }
            else if (bracket.equals('}') && !deque.isEmpty() && deque.peekFirst().equals('{')) {
                deque.pop();
            }
            else {
                return false;
            }

        }

        return (deque.isEmpty()) ? true : false;


    }
}
