package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/11403
public class Prob11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] adjMap = new int[n][];
        for (int i = 0; i < n; i++) {
            adjMap[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int m = 0; m < n; m++) {
            for (int s = 0; s < n; s++) {
                for (int e = 0; e < n; e++) {
                    if (adjMap[s][e] != 1 && (adjMap[s][m] == 1 && adjMap[m][e] == 1))
                        adjMap[s][e] = 1;
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        Arrays.stream(adjMap).forEach(row -> {
            Arrays.stream(row)
                    .forEach(i -> answer.append(i).append(' '));
            answer.append('\n');
        });

        System.out.println(answer);
    }
}

