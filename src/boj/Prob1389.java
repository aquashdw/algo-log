package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1389
public class Prob1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[][] distMap = new int[nm[0] + 1][nm[0] + 1];
        for (int[] distRow: distMap) Arrays.fill(distRow, 10000);
        reader.lines().limit(nm[1])
                .map(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .forEach(edge -> {
                    distMap[edge[0]][edge[1]] = 1;
                    distMap[edge[1]][edge[0]] = 1;
                });

        for (int i = 1; i < nm[0] + 1; i++) {
            for (int j = 1; j < nm[0] + 1; j++) {
                for (int k = 1; k < nm[0] + 1; k++) {
                    if (distMap[j][k] > distMap[j][i] + distMap[i][k])
                        distMap[j][k] = distMap[j][i] + distMap[i][k];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        for (int i = 1; i < nm[0] + 1; i++) {
            int baker = Arrays.stream(distMap[i]).skip(1).sum();
            if (min > baker) {
                min = baker;
                minIdx = i;
            }
        }
        System.out.println(minIdx);
    }
}

