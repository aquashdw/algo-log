package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// https://www.acmicpc.net/problem/14888
public class Prob14888 {
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] operators = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        perm(n, numbers, operators);

        StringBuilder answerBuilder = new StringBuilder();
        answerBuilder.append(max)
                .append('\n')
                .append(min);
        System.out.println(answerBuilder);
    }

    public static void perm(int n, int[] numbers, int[] operators) {
        permRecursive(n, numbers, operators, new int[n - 1], 0);
    }

    public static void permRecursive(int n, int[] numbers, int[] operators, int[] perm, int depth) {
        // 숫자의 갯수 - 1이 연산자 선택 횟수이다.
        if (depth == n - 1) {
            // 연산자 조합대로 계산해본다.
            int result = getResult(n, numbers, perm);
            max = Math.max(result, max);
            min = Math.min(result, min);
        }
        else {
            for (int i = 0; i < 4; i++) {
                if (operators[i] == 0) continue;
                operators[i]--;
                perm[depth] = i;
                permRecursive(n, numbers, operators, perm, depth + 1);
                operators[i]++;
            }
        }
    }

    private static int getResult(int n, int[] numbers, int[] perm) {
        int result = numbers[0];
        for (int i = 0; i < n - 1; i++) {
            switch (perm[i]) {
                case 0:
                    result += numbers[i + 1];
                    break;
                case 1:
                    result -= numbers[i + 1];
                    break;
                case 2:
                    result *= numbers[i + 1];
                    break;
                case 3:
                    result /= numbers[i + 1];
                    break;
            }
        }
        return result;
    }
}
