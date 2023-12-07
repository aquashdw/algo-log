package bf;

import java.util.Arrays;

public class Permutation {
    public static void main(String[] args) {
        // 하나를 고른다
        for (int i = 1; i < 6; i++) {
            // 다음 하나를 고르는데
            for (int j = 1; j < 6; j++) {
                // 이미 고른건 스킵
                if (i == j) continue;
                // 마지막 하나도 고른다.
                for (int k = 1; k < 6; k++) {
                    // 역시 이미 골랐으면 스킵
                    if (i == k || j == k) continue;
                    // nPr => n == 6, r == 3의 결과 하나 출력
                    System.out.println(i + " " + j + " " + k);
                }
            }
        }

        // 배열을 기준으로 한다면,
        int[] numbers = new int[]{10, 13, 14, 16};
        // 배열의 원소중 몇번째를 고를지 선택
        for (int i = 0; i < numbers.length; i++) {
            // 다음 순서를 고르는데,
            for (int j = 0; j < numbers.length; j++) {
                // 이미 선택한 적 있으면 스킵
                if (i == j) continue;
                // 마지막 하나도 고른다.
                for (int k = 0; k < numbers.length; k++) {
                    // 이미 선택한 적 있으면 스킵
                    if (i == k || j == k) continue;
                    // nPr => n == 4, r == 3의 결과 하나 출력, 배열의 원소를 기준으로 가져온다.
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
