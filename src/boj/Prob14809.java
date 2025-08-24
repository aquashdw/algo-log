package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/14809
public class Prob14809 {
    private static long[][] pancakes;
    private static long max;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 0; test < tests; test++) {
            int[] info = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            max = 0;
            pancakes = new long[info[0]][];
            for (int i = 0; i < pancakes.length; i++) {
                pancakes[i] = Arrays.stream(reader.readLine().split(" "))
                        .mapToLong(Integer::parseInt).toArray();
            }
            stackPancake(0, 0, new int[info[1]]);
            answer.append(String.format("Case #%d: ", test + 1)).append(max * Math.PI).append('\n');
        }
        System.out.print(answer);
    }

    private static void stackPancake(int now, int count, int[] selected) {
        // if selected enough
        if (count == selected.length) {
            // calculate max
            long flatArea = Arrays.stream(selected)
                    .mapToLong(i -> pancakes[i][0])
                    .max().orElse(0);
            flatArea *= flatArea;

            long sideArea = Arrays.stream(selected)
                    .mapToLong(i -> {
                        long[] pancake = pancakes[i];
                        return 2 * pancake[0] * pancake[1];
                    })
                    .sum();

            max = Math.max(max, flatArea + sideArea);

            return;
        }

        if (now == pancakes.length) {
            return;
        }

        selected[count] = now;
        stackPancake(now + 1, count + 1, selected);
        stackPancake(now + 1, count, selected);
    }
}
