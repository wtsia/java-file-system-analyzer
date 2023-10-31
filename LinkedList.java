class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void add(String data, String type, long bytes) {
        Node newNode = new Node(data, type, bytes);
        if (head == null) {
            head = newNode;
        } else {
            if (searchByType(type) == null) {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            } else {
                searchByType(type).count += 1;
            }
        }
    }

    private Node searchByType(String type) {
        Node current = head; // Assuming 'head' as the reference to the first node in the linked list
        while (current != null) {
            if (current.type.equals(type)) {
                // Found the node with matching 'type', return the node
                return current;
            }
            current = current.next; // Move to the next node
        }
        return null; // 'type' not found in the linked list
    }

    public void iterateList() {
        Node current = head;
        while (current != null) {
            System.out.println("Type: " + current.type + ", Count: " + current.count + ", Bytes: " + current.bytes);
            current = current.next;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}