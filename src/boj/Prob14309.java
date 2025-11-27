package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/14309
public class Prob14309 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 0; test < tests; test++) {
            int[] rck = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int rows = rck[0];
            int cols = rck[1];
            long[][] world = new long[rows][cols];
            for (long[] row : world) {
                Arrays.fill(row, 1);
            }

            reader.lines().limit(rck[2]).forEach(line -> {
                int[] position = Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                world[position[0]][position[1]] = 0;
            });

            for (int i = 1; i < rows; i++) {
                for (int j = 1; j < cols; j++) {
                    if (world[i][j] == 0) continue;
                    world[i][j] = min(world[i - 1][j], world[i][j - 1], world[i - 1][j - 1]) + 1;
                }
            }

            long total = Arrays.stream(world).mapToLong(row -> Arrays.stream(row).sum()).sum();
            answer.append(String.format("Case #%d: %d%n", test + 1, total));
        }
        System.out.print(answer);
    }

    private static long min(long... vars) {
        long min = vars[0];
        for (int i = 1; i < vars.length; i++) {
            min = Math.min(min, vars[i]);
        }
        return min;
    }
}
