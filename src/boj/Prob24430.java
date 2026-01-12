package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/24430
public class Prob24430 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] matrix = new int[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int p = Integer.parseInt(reader.readLine());
        int[][] targets = new int[n][n];
        for (int i = 0; i < p; i++) {
            int[] point = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            targets[point[0] - 1][point[1] - 1] = 1;
        }

        int[][] scores = new int[n][n];
        int[][] routes = new int[n][n];
        scores[0][0] = matrix[0][0];
        routes[0][0] = targets[0][0];
        for (int i = 1; i < n; i++) {
            scores[0][i] += matrix[0][i];
            scores[0][i] += scores[0][i - 1];

            routes[0][i] += targets[0][i];
            routes[0][i] += routes[0][i - 1];

            scores[i][0] += matrix[i][0];
            scores[i][0] += scores[i - 1][0];
            routes[i][0] += targets[i][0];
            routes[i][0] += routes[i - 1][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                scores[i][j] = Math.max(scores[i - 1][j], scores[i][j - 1]) + matrix[i][j];
                if (scores[i - 1][j] == scores[i][j - 1])
                    routes[i][j] = Math.max(routes[i - 1][j], routes[i][j - 1]) + targets[i][j];
                else if (scores[i - 1][j] > scores[i][j - 1])
                    routes[i][j] = routes[i - 1][j] + targets[i][j];
                else
                    routes[i][j] = routes[i][j - 1] + targets[i][j];
            }
        }

        System.out.printf("%d %d%n", scores[n - 1][n - 1], routes[n - 1][n - 1]);
    }

}
