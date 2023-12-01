package sort;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {0, 1, 4, 4, 3, 0, 5, 2, 5, 1};
        int n = arr.length;

        int[] count = new int[6];
        for (int data : arr) {
            count[data]++;
        }

//        // prefix vs count
//        int[] prefix = new int[6];
//        prefix[0] = count[0];
//        for (int i = 0; i < 5; i++) {
//            prefix[i + 1] += count[i + 1] + prefix[i];
//        }
//
//        System.out.println(Arrays.toString(count));
//        System.out.println(Arrays.toString(prefix));
//
//        count = prefix;


        for (int i = 0; i < 5; i++) {
            count[i + 1] += count[i];
        }
        System.out.println(Arrays.toString(count));

        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            count[arr[i]]--;
            int position = count[arr[i]];
            output[position] = arr[i];
        }

        System.out.println(Arrays.toString(output));
    }
}
