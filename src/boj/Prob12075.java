package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/12075
public class Prob12075 {
    private static final long base = 1152921504606846975L;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        long ceil = 1000000000000000000L;
//        long digits = 0;
//        int reps = 0;
//        while (digits < ceil) {
//            digits *= 2;
//            digits++;
//            reps++;
//        }
//        System.out.println(digits / 2 + 1);

        StringBuilder answer = new StringBuilder();
        int tests = Integer.parseInt(reader.readLine());
        for (int i = 0; i < tests; i++) {
            answer.append("Case #").append(i + 1).append(": ");
            answer.append(getDigit(Long.parseLong(reader.readLine())));
            answer.append("\n");
        }
        System.out.print(answer);
    }

    private static char getDigit(long k) {
        return getDigit(k, base, 0);
    }

    private static char getDigit(long k, long digits, int flips) {
        long half = digits / 2 + 1;
        if (k == 1 || k == half) {
            return flips % 2 == 0 ? '0' : '1';
        }
        if (k > half) {
            flips++;
            k = half - (k - half);
        }
        return getDigit(k, half - 1, flips);
    }
}
// 1,000,000,000,000,000,000
// 9,223,372,036,854,775,807
