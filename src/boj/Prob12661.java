package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/12661
public class Prob12661 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 0; test < tests; test++) {
            answer.append(String.format("Case #%d: ", test + 1));
            int n = Integer.parseInt(reader.readLine());
            int[][] requirements = reader.lines().limit(n)
                    .map(line -> Arrays.stream(line.split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray())
                    .toArray(int[][]::new);
            long max = 0;
            for (int i = (1 << n) - 1; i > 0; i--) {
                int mask = i;
                int[] targets = IntStream.range(0, n)
                        .filter(j -> ((1 << j) & mask) > 0)
                        .toArray();
                int[] drink = Arrays.stream(targets)
                        .mapToObj(target -> requirements[target])
                        .reduce(new int[]{0, 0, 0}, (prev, now) -> {
                            prev[0] = Math.max(prev[0], now[0]);
                            prev[1] = Math.max(prev[1], now[1]);
                            prev[2] = Math.max(prev[2], now[2]);
                            return prev;
                        });
                if (Arrays.stream(drink).sum() <= 10000) {
                    max = Math.max(max, Arrays.stream(targets).count());
                }
            }
            answer.append(max);
            answer.append('\n');
        }
        System.out.print(answer);
    }
}
