package heap;

import java.util.Arrays;

public class BinaryMaxHeap {
    private int[] heap;
    private int size;

    public BinaryMaxHeap() {
        heap = new int[32];
        size = 0;
    }

    public BinaryMaxHeap(int[] arr) {
        heap = Arrays.copyOf(arr, arr.length);
        size = arr.length;

        int lastIndex = arr.length - 1;
        int lastParentIndex = (lastIndex - 1) / 2;
        for (int i = lastParentIndex; i >= 0; i--) {
            siftDown(i);
        }
    }

    public void insert(int item) {
        if (size == heap.length) {
            throw new RuntimeException("Heap is full");
        }

        heap[size] = item;
        siftUp(size);
        size++;
    }

    public int remove() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }

        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        siftDown(0);

        return root;
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;

            if (heap[index] <= heap[parentIndex]) {
                break;
            }

            int temp = heap[index];
            heap[index] = heap[parentIndex];
            heap[parentIndex] = temp;
            index = parentIndex;
        }
    }

    private void siftDown(int index) {
        while (index < size) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int largest = index;

            if (leftChild < size && heap[leftChild] > heap[largest]) {
                largest = leftChild;
            }

            if (rightChild < size && heap[rightChild] > heap[largest]) {
                largest = rightChild;
            }

            if (largest == index) {
                break;
            }

            int temp = heap[index];
            heap[index] = heap[largest];
            heap[largest] = temp;
            index = largest;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {

        BinaryMaxHeap maxHeap = new BinaryMaxHeap(new int[]{1, 21, 14, 6, 10, 2, 5, 6, 8});
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.remove());
        }
    }
}
