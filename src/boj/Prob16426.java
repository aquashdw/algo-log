package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/16426
public class Prob16426 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] sculpture = reader.lines().limit(nm[0])
                .map(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .toArray(int[][]::new);
        int[][] drains = new int[nm[0]][nm[1]];

        for (int i = 1; i < nm[0] - 1; i++) {
            for (int j = 1; j < nm[1] - 1; j++) {
                int now = sculpture[i][j];
                if (now < sculpture[i - 1][j] && now < sculpture[i][j - 1] &&
                        now < sculpture[i + 1][j] && now < sculpture[i][j + 1])
                    drains[i][j] = 1;
            }
        }

        StringBuilder answer = new StringBuilder();
        Arrays.stream(drains).map(row -> Arrays.stream(row)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")))
                .forEach(line -> answer.append(line).append('\n'));
        System.out.print(answer);
    }
}
