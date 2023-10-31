class Node {
    String data;
    String type;
    int count;
    long bytes;
    Node next;

    public Node(String data, String type, long bytes) {
        this.data = data;
        this.next = null;
        this.count = 1;
        this.bytes = bytes;
        this.type = type;
    }
}