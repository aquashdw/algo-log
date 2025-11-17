package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// same as 14326
// https://www.acmicpc.net/problem/14327
public class Prob14327 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 0; test < tests; test++) {
            answer.append(String.format("Case #%d: ", test + 1));
            int months = Integer.parseInt(reader.readLine());
            int[] money = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            money[0] *= -1;
            int sign = Arrays.stream(money).sum() >= 0 ? 1 : -1;
            int level = 1;
            double rate = 0;
            for (int i = 0; i < 10; i++) {
                double before = calculate(money, months, rate * sign);
                double beforeRate = rate;
                if (before == 0) break;
                boolean zeroed = false;
                for (int j = 1; j < 11; j++) {
                    double newRate = rate + j * Math.pow(0.1, level);
                    double now = calculate(money, months, newRate * sign);
                    if (now == 0) {
                        zeroed = true;
                        rate = newRate;
                        break;
                    }
                    if (now * before < 0) {
                        rate = beforeRate;
                        break;
                    }
                    before = now;
                    beforeRate = newRate;
                }
                if (zeroed) break;
                level++;
            }
            answer.append(rate * sign).append('\n');
        }
        System.out.println(answer);
    }

    private static double calculate(int[] money, int months, double rate) {
        double total = 0;
        for (int i = 0; i < months + 1; i++) {
            total += money[i] * Math.pow(1 + rate, months - i);
        }
        return total;
    }
}
