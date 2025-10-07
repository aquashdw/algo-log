package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// https://www.acmicpc.net/problem/2170
public class Prob2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] lines = reader.lines().limit(n)
                .map(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt).toArray())
                .sorted(Comparator.comparingInt(o -> o[0]))
                .toArray(int[][]::new);

        int total = 0;
        int[] current = {-1000000000, -1000000000};
        for (int[] line : lines) {
            if (line[0] > current[1]) {
                total += current[1] - current[0];
                current[0] = line[0];
                current[1] = line[1];
            } else {
                current[1] = Math.max(current[1], line[1]);
            }
        }
        total += current[1] - current[0];
        System.out.println(total);
    }
}
