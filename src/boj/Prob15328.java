package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;

// https://www.acmicpc.net/problem/15328
public class Prob15328 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int tests = Integer.parseInt(reader.readLine());
        int[][] distances = new int[4][];
        for (int i = 0; i < tests; i++) {
            int time = Integer.parseInt(reader.readLine());
            for (int j = 0; j < 4; j++) {
                distances[j] = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }
            answer.append(test(time, distances) ? "YES\n" : "NO\n");
        }
        System.out.print(answer);
    }

    private static boolean test(int time, int[][] distances) {
        BigDecimal sum = BigDecimal.ZERO;
        int[] last = {0, 0, 0};
        for (int i = 0; i < 4; i++) {
            int xDiff = distances[i][0] - last[0];
            int yDiff = distances[i][1] - last[1];
            int zDiff = distances[i][2] - last[2];
            int distSquared = xDiff * xDiff + yDiff * yDiff + zDiff * zDiff;
            sum = sum.add(sqrt(distSquared));
            last = distances[i];
        }
        return sum.compareTo(BigDecimal.valueOf(time)) <= 0;
    }

    private static BigDecimal sqrt(int squared) {
        BigDecimal origin = BigDecimal.valueOf(squared);
        BigDecimal low = BigDecimal.ZERO;
        BigDecimal high = BigDecimal.valueOf(squared);
        for (int i = 0; i < 100; i++) {
            BigDecimal mid = low.add(high).divide(BigDecimal.valueOf(2));
            if (mid.multiply(mid).compareTo(origin) < 0) low = mid;
            else high = mid;
        }
        return low;
    }
}
/*
0 0 0
0 0 2
0 0 2
0 0 4 -> 2

0 0 2
0 0 3
0 0 1
0 0 1 -> 1

0 0 3
0 0 0
0 0 3
0 0 9 -> 3
 */
