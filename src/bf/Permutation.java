package bf;

import java.util.Arrays;

public class Permutation {
    public static void main(String[] args) {
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                if (i == j) continue;
                for (int k = 1; k < 4; k++) {
                    if (i == k || j == k) continue;
                    System.out.println(i + " " + j + " " + k);
                }
            }
        }

        int[] numbers = new int[]{10, 13, 14, 16};
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) continue;
                for (int k = 0; k < numbers.length; k++) {
                    if (i == k || j == k) continue;
                    System.out.println(numbers[i] + " " + numbers[j] + " " + numbers[k]);
                }
            }
        }

        Permutation perm = new Permutation();
        perm.permNumbers(3, 3, 0, new int[3], new boolean[3]);

        perm.permArray(new int[]{1, 2, 3}, 3, 0, new int[3], new boolean[3]);
    }

    private void permNumbers(int n, int r, int k, int[] perm, boolean[] used) {
        if (r == k) {
            System.out.println(Arrays.toString(perm));
        }
        else {
            for (int i = 0; i < n; i++) {
                if (used[i]) continue;
                perm[k] = i;
                used[i] = true;
                this.permNumbers(n, r, k + 1, perm, used);
                used[i] = false;
            }
        }
    }

    private void permArray(
            int[] numbers,
            int r,
            int k,
            int[] perm,
            boolean[] used
    ) {
        if (r == k) {
            System.out.println(Arrays.toString(perm));
        }
        else {
            for (int i = 0; i < numbers.length; i++) {
                if (used[i]) continue;
                perm[k] = numbers[i];
                used[i] = true;
                this.permArray(numbers, r, k + 1, perm, used);
                used[i] = false;
            }
        }
    }
}
