class MinStack {

    class Node {
        int val;
        int currentMin;
        Node next;
        Node (int val) {
            this.val = val;
        }
    }

    Node top;



    public MinStack() {
        
    }
    
    public void push(int val) {
        Node temp = new Node(val);
        if (top == null) {
            temp.currentMin = val;
            temp.next = null;
            top = temp;
        }
        else {
            if (val <= top.currentMin) {
                temp.currentMin = val;
            }
            else {
                temp.currentMin = top.currentMin;
            }
            temp.next = top;
            top = temp;
        }
    }
    
    public void pop() {
        top = top.next;
    }
    
    public int top() {
        return top.val;
    }
    
    public int getMin() {
        return top.currentMin;
    }
}
