class LRUCache {
    Map<Integer, Node> map = new HashMap<>();
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    int capacity;
    public LRUCache(int capacity) {
       this.capacity = capacity;
       head.right = tail;
       tail.left = head;
    }
    
    public int get(int key) {
        Node value = map.get(key);
        if(value == null){
            return -1;
        }
        moveToFront(value);
        return value.value;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)) {
            if(map.size() == capacity){
                map.remove(tail.left.key);
                remove(tail.left);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            addToFront(node);
        } else {
            Node node = map.get(key);
            node.value = value;
            moveToFront(node);
        }
    }

    public void addToFront(Node node){
        Node temp = head.right;
        head.right = node;
        node.right = temp;
        node.left = head;
        temp.left = node;

    }
    public void moveToFront(Node node){
        remove(node);
        addToFront(node);
    }

    public void remove(Node node) {
        node.left.right = node.right;
        node.right.left = node.left; 
    }
    private static class Node {
        Node left, right;
        int key, value;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
