import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    static class heapNode {
        String type;
        int count;
        long bytes;

        heapNode(String type, int count, long bytes) {
            this.type = type;
            this.count = count;
            this.bytes = bytes;
        }
    }

    private final List<heapNode> heap;

    MaxHeap() {
        heap = new ArrayList<>();
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        heapNode temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private void heapifyUp(int index) {
        int currentIndex = index;
        while (currentIndex > 0 && heap.get(parent(currentIndex)).count < heap.get(currentIndex).count) {
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }
    }

    private void heapifyDown(int index) {
        int maxIndex = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < heap.size() && heap.get(left).count > heap.get(maxIndex).count) {
            maxIndex = left;
        }

        if (right < heap.size() && heap.get(right).count > heap.get(maxIndex).count) {
            maxIndex = right;
        }

        if (index != maxIndex) {
            swap(index, maxIndex);
            heapifyDown(maxIndex);
        }
    }

    public void insert(String type, int count, long bytes) {
        if (type.equals("Unknown")) {
        } else {
            heapNode newNode = new heapNode(type, count, bytes);
            heap.add(newNode);
            heapifyUp(heap.size() - 1);
        }
    }

    public heapNode extractMax() {
        if (heap.size() == 0) {
            return null;
        }

        heapNode maxNode = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapifyDown(0);
        return maxNode;
    }

    public void printHeap() {
        System.out.println("Max Heap: ");
        for (heapNode node : heap) {
            System.out.println("Type: " + node.type + ", Count: " + node.count + ", Bytes: " + node.bytes);
        }
    }

    public List<heapNode> searchByTopNCounts(int n) {
        List<heapNode> topNNodes = new ArrayList<>();

        int heapSize = heap.size();
        int count = 0;
        int currentIndex = 0;

        while (count < n && currentIndex < heapSize) {
            topNNodes.add(heap.get(currentIndex));
            count++;
            currentIndex++;
        }

        return topNNodes;
    }

    public void insertLinkedList(LinkedList list) {
        Node current = list.head;
        while (current != null) {
            insert(current.type, current.count, current.bytes);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();

        maxHeap.insert("A", 15, (long) 1.0);
        maxHeap.insert("B", 10, (long) 2.0);
        maxHeap.insert("C", 20, (long) 3.0);
        maxHeap.insert("D", 5, (long) 4.0);
        maxHeap.insert("E", 25, (long) 5.0);

        maxHeap.printHeap();

        int topN = 3; // Specify the number of top counts to retrieve

        List<heapNode> topNNodes = maxHeap.searchByTopNCounts(topN);
        if (!topNNodes.isEmpty()) {
            System.out.println("\nTop " + topN + " Nodes with Highest Counts:");
            for (heapNode node : topNNodes) {
                System.out.println("Type: " + node.type + ", Count: " + node.count);
            }
        } else {
            System.out.println("Heap is empty.");
        }
    }
}
