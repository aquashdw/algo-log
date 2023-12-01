package heap;

import java.util.Arrays;

public class HeapSort {
    private int size;
    public void sort(int[] array) {
        size = array.length;

        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(array, size, i);
        }

        for (int i = size - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    private void heapify(int[] array, int heapSize, int index) {
        while (index < heapSize) {
            int largest = index;
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;

            if (leftChild < heapSize && array[leftChild] > array[largest]) {
                largest = leftChild;
            }
            if (rightChild < heapSize && array[rightChild] > array[largest]) {
                largest = rightChild;
            }

            if (largest == index)
                break;

            int temp = array[index];
            array[index] = array[largest];
            array[largest] = temp;

            index = largest;
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 4, 7, 1, 2, 6, 3};
        new HeapSort().sort(array);
        System.out.println(Arrays.toString(array));
    }
}
