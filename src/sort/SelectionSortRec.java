package sort;

import java.util.Arrays;

public class SelectionSortRec {
    public static void main(String[] args) {
        int[] arr = {25, 12, 18, 24, 2, 21};
        new SelectionSortRec().sort(arr, 0);
        System.out.println(Arrays.toString(arr));
    }


    private void sort(int[] arr, int start) {
        if (!(start < arr.length)) {
            return;
        }

        int minIndex = start;
        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }

        int temp = arr[start];
        arr[start] = arr[minIndex];
        arr[minIndex] = temp;

        sort(arr, start + 1);
    }
}
