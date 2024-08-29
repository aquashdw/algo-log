package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/11971
public class Prob11971 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] ranges = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = ranges[0];
        int m = ranges[1];
        int[][] roads = new int[n][];
        for (int i = 0; i < n; i++) {
            roads[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] speedRecords = new int[m][];
        for (int i = 0; i < m; i++) {
            speedRecords[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int maxOver = 0;
        int speedIdx = 0;
        int nextSpeedChange = speedRecords[speedIdx][0];
        int roadIdx = 0;
        int nextRoadChange = roads[roadIdx][0];
        for (int i = 1; i < 101; i++) {
            if (i > nextRoadChange) {
                roadIdx++;
                nextRoadChange += roads[roadIdx][0];
            }
            if (i > nextSpeedChange) {
                speedIdx++;
                nextSpeedChange += speedRecords[speedIdx][0];
            }
            maxOver = Math.max(maxOver, speedRecords[speedIdx][1] - roads[roadIdx][1]);
        }

        System.out.println(maxOver);
    }
}
/*
3 3
30 100
30 110
40 120
30 100
30 110
40 120
 */