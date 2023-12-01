package bf;

import java.util.Arrays;

public class Combination {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    System.out.printf("%d %d %d%n", i, j, k);
                }
            }
        }

        int[] numbers = new int[]{2, 3, 5, 7, 11};
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    System.out.printf(
                            "%d %d %d%n",
                            numbers[i],
                            numbers[j],
                            numbers[k]);
                }
            }
        }


        Combination comb = new Combination();
        comb.combNumbers(5, 3, 0, 0, new int[3]);

        comb.combArray(new int[]{2, 3, 5, 7, 11}, 3, 0, 0, new int[3]);
    }

    private void combArray(
            int[] numbers,
            int r,
            int k,
            int next,
            int[] comb
    ) {
        // k == r: 고를 만큼 원소를 골랐다
        if (k == r) {
            System.out.println(Arrays.toString(comb));
        }
        // next == n: 고르기 전 고를 대상이 떨어졌다
        else if(next == numbers.length) {
            return;
        }
        else {
            // comb[k]에 이번에 판단중인 숫자를 우선 할당한다.
            comb[k] = numbers[next];
            // next를 선택하고, k + 1번째 원소를 판단하러 넘어간다.
            combArray(numbers, r, k + 1, next + 1, comb);
            // next를 선택하지 않고 k번째 원소를 판단하러 넘어간다.
            // next를 선택하지 않으면 comb[k]에 할당한 next는 덮어씌워진다.
            combArray(numbers, r, k, next + 1, comb);
        }
    }

    private void combNumbers(
            // 몇개 중
            int n,
            // 몇개 뽑을 지
            int r,
            // 몇번째 원소를 고르고 있는지
            int k,
            // 어떤 숫자를 판단하고 있는지
            int next,
            // 현재 완성한 조합
            int[] comb
    ) {
        // k == r: 고를 만큼 원소를 골랐다
        if (k == r) {
            System.out.println(Arrays.toString(comb));
        }
        // next == n: 고르기 전 고를 대상이 떨어졌다
        else if(next == n) {
            return;
        }
        else {
            // comb[k]에 이번에 판단중인 숫자를 우선 할당한다.
            comb[k] = next;
            // next를 선택하고, k + 1번째 원소를 판단하러 넘어간다.
            combNumbers(n, r, k + 1, next + 1, comb);
            // next를 선택하지 않고 k번째 원소를 판단하러 넘어간다.
            // next를 선택하지 않으면 comb[k]에 할당한 next는 덮어씌워진다.
            combNumbers(n, r, k, next + 1, comb);
        }
    }
}
