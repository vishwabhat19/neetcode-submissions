class LRUCache {
    Map<Integer, Node> map;
    int capacity;
    DL list;



    class Node {
        Node prev;
        Node next;
        int key;
        int value;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DL {
        Node head;
        Node tail;

        DL() {
            head = null;
            tail = null;
        }

        void addAtHead(Node temp) {
            if (head == null) {
                head = temp;
                tail = temp;
                temp.prev = null;
            }
            else {
                head.prev = temp;
                temp.next = head;
                head = temp;
                temp.prev = null;
            }
        }

        void remove(Node temp) {
            //Fix the forward link
            //Hey the node ahead of me, dont point to me, point to the node behind because i am dead
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
            else {
                //But if the node being removed is the tail, then there is nothing ahead
                tail = temp.prev; //So just tell that the tail is now the node behind me since i am dead
            }

            //Fix the backward link
            if (temp.prev != null) {
                //Hey the node behind me. point to the node in front of me. because i am gone
                temp.prev.next = temp.next;
            }
            else {
                //if the node being removed is the head then point head to my next
                head = temp.next;
            }
            
        }

    }

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.capacity = capacity;
        list = new DL();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node temp = map.get(key);
        list.remove(temp);
        list.addAtHead(temp);
        return temp.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            temp.value = value;
            map.put(key, temp);
            list.remove(temp);
            list.addAtHead(temp);
            return;
        }
        else {
            if (map.size() >= capacity) {
                Node lru = list.tail;
                map.remove(lru.key);
                list.remove(lru);
            }
            Node temp = new Node(key, value);
            list.addAtHead(temp);
            map.put(key, temp);

        }
    }
}
