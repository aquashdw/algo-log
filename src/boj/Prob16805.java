package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/16805
public class Prob16805 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = nm[0];
        int m = nm[1];
        char[][] features = new char[m][];
        int[] wCounts = new int[m];
        for (int i = 0; i < m; i++) {
            features[i] = reader.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                wCounts[i] += features[i][j] == 'W' ? 1 : 0;
            }
        }

        int minError = Arrays.stream(wCounts).sum();
        int minIdx = -1;

        int nowError = minError;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (features[j][i] == 'E') nowError++;
                else nowError--;
            }
            if (nowError < minError) {
                minError = nowError;
                minIdx = i;
            }
        }
        System.out.printf("%d %d%n", minIdx + 1, minIdx + 2);
    }
}
