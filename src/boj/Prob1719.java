package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1719
public class Prob1719 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int n = nm[0];
        int m = nm[1];

        int[][] adjMat = new int[n + 1][n + 1];
        int[][] routeGraph = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            int[] row = adjMat[i];
            Arrays.fill(row, 1000000000);
            adjMat[i][i] = 0;
            routeGraph[i][i] = 1000000000;
        }

        reader.lines().limit(m).forEach(line -> {
            int[] edge = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            adjMat[edge[0]][edge[1]] = edge[2];
            adjMat[edge[1]][edge[0]] = edge[2];
            routeGraph[edge[0]][edge[1]] = edge[1];
            routeGraph[edge[1]][edge[0]] = edge[0];
        });

        for (int mid = 1; mid < n + 1; mid++) {
            for (int start = 1; start < n + 1; start++) {
                for (int goal = 1; goal < n + 1; goal++) {
                    if (adjMat[start][goal] > adjMat[start][mid] + adjMat[mid][goal]) {
                        adjMat[start][goal] = adjMat[start][mid] + adjMat[mid][goal];
                        routeGraph[start][goal] = routeGraph[start][mid];
                    }
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) answer.append('-');
                else answer.append(routeGraph[i][j]);
                if (j != n) answer.append(' ');
            }
            answer.append('\n');
        }
        System.out.print(answer);
    }
}
