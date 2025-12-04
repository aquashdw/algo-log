package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// https://www.acmicpc.net/problem/6002
public class Prob6002 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int wage = info[0];
        int paths = info[1];
        int cities = info[2];
        int jets = info[3];
        int first = info[4];

        long[][] dists = new long[cities + 1][cities + 1];
        for (long[] row : dists) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = 1; i < cities + 1; i++) {
            dists[i][i] = 0;
        }

        reader.lines().limit(paths).forEach(line -> {
            int[] path = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            dists[path[0]][path[1]] = -wage;
        });

        reader.lines().limit(jets).forEach(line -> {
            int[] jet = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            dists[jet[0]][jet[1]] = Math.min(dists[jet[0]][jet[1]], jet[2] - wage);
        });

        for (int start = 1; start < cities + 1; start++) {
            for (int end = 1; end < cities + 1; end++) {
                for (int mid = 1; mid < cities + 1; mid++) {
                    if (start == mid || end == mid) continue;
                    dists[start][end] = Math.min(dists[start][end], dists[start][mid] + dists[mid][end]);
                }
            }
        }

        long minCost = Arrays.stream(dists[first]).skip(1).min().orElseThrow();
        System.out.println(Math.abs(minCost - wage));
    }
}
