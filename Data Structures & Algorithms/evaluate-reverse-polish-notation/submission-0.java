class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> dq = new ArrayDeque<>();
        for(int i=0;i<tokens.length;i++) {
            String token = tokens[i];
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                Integer a = Integer.parseInt(dq.pop());
                Integer b = Integer.parseInt(dq.pop());
                if (token.equals("+")) {
                    dq.push(String.valueOf(a+b));
                }
                else if (token.equals("-")) {
                    dq.push(String.valueOf(b-a));
                }
                else if (token.equals("/")) {
                    dq.push(String.valueOf(b/a));
                }
                else if (token.equals("*")) {
                    dq.push(String.valueOf(b*a));
                }
            }
            else {
                dq.push(token);
            }
        }
        return Integer.parseInt(dq.pop());
    }
}
