package dnc;

import java.util.Arrays;

public class QuickSort {
    public void sort(int[] arr) {
        // 비었거나 길이가 1 이하라면 정렬할 필요가 없다.
        if (arr == null || arr.length <= 1) {
            return;
        }

        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 현재 배열을 나눈다.
            int pivotIndex = partition(arr, low, high);

            // 나눈 배열을 각각 Quick Sort한다.
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        // 오른쪽 끝에 있는 원소를 pivot으로 설정한다.
        int pivot = arr[high];
        // 작은 원소를 보낼 왼쪽 index
        int i = low - 1;

        // 나눠진 배열의 원소를 오른쪽 끝(pivot) 제외 전부 확인한다.
        for (int j = low; j < high; j++) {
            // 현재 원소의 값이 pivot보다 작을 경우
            if (arr[j] <= pivot) {
                i++;
                // 현재 원소를 왼쪽으로 보낸다.
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 이 과정이 끝나면 마지막으로 pivot 보다 작은 원소가 i에 저장된다.
        // i + 1 의 원소와 pivot 의 원소를 교환하면
        // i + 1 의 왼쪽에는 pivot 보다 작은 원소만,
        // i + 1 의 오른쪽에는 pivot 보다 큰 원소만 남는다.
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // Quick Sort의 한단계가 끝나면 pivot의 위치에서
        // 좌우 배열을 다시 정렬해야 한다. 이를 위해 pivot의 마지막 위치를 반환한다.
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 1, 7, 4, 8, 6, 2, 5};
        new QuickSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
