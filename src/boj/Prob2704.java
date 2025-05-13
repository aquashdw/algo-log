package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/2704
public class Prob2704 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).forEach(line -> {
            int[] time = Arrays.stream(line.split(":"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int[][] binTime = new int[3][6];
            for (int i = 0; i < 3; i++) {
                int pointer = 1;
                for (int j = 0; j < 6; j++) {
                    if ((pointer & time[i]) != 0) {
                        binTime[i][5 - j] = 1;
                    }
                    pointer <<= 1;
                }
            }

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    answer.append(binTime[j][i]);
                }
            }
            answer.append(' ');
            for (int i = 0; i < 3; i++) {
                answer.append(Arrays.stream(binTime[i])
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining("")));
            }
            answer.append('\n');
        });
        System.out.print(answer);
    }
}
