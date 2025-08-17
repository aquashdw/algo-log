package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2985
public class Prob2985 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] digits = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int lSum = digits[0] + digits[1];
        if (lSum == digits[2]) {
            System.out.printf("%d+%d=%d%n", digits[0], digits[1], digits[2]);
            return;
        }
        int lDiff = digits[0] - digits[1];
        if (lDiff == digits[2]) {
            System.out.printf("%d-%d=%d%n", digits[0], digits[1], digits[2]);
            return;
        }
        int lPro = digits[0] * digits[1];
        if (lPro == digits[2]) {
            System.out.printf("%d*%d=%d%n", digits[0], digits[1], digits[2]);
            return;
        }
        int lDiv = digits[0] / digits[1];
        if (lDiff == digits[2] && digits[0] % digits[1] == 0) {
            System.out.printf("%d/%d=%d%n", digits[0], digits[1], digits[2]);
            return;
        }

        int rSum = digits[1] + digits[2];
        if (rSum == digits[0]) {
            System.out.printf("%d=%d+%d%n", digits[0], digits[1], digits[2]);
            return;
        }
        int rDiff = digits[1] - digits[2];
        if (rDiff == digits[0]) {
            System.out.printf("%d=%d-%d%n", digits[0], digits[1], digits[2]);
            return;
        }
        int rProd = digits[1] * digits[2];
        if (rProd == digits[0]) {
            System.out.printf("%d=%d*%d%n", digits[0], digits[1], digits[2]);
            return;
        }
        int rDiv = digits[1] / digits[2];
        if (rDiv == digits[0] && digits[1] % digits[2] == 0) {
            System.out.printf("%d=%d/%d%n", digits[0], digits[1], digits[2]);
            return;
        }
    }
}
