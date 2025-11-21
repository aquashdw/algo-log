package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/14938
public class Prob14938 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int nodes = info[0];
        int range = info[1];
        int edges = info[2];

        int[] items = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[][] dist = new int[nodes + 1][nodes + 1];
        Arrays.stream(dist).forEach(row -> Arrays.fill(row, 1500));
        for (int i = 1; i < nodes + 1; i++) {
            dist[i][i] = 0;
        }
        for (int i = 0; i < edges; i++) {
            int[] edge = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }

        for (int mid = 1; mid < nodes + 1; mid++) {
            for (int start = 1; start < nodes + 1; start++) {
                for (int end = 1; end < nodes + 1; end++) {
                    if (dist[start][end] > dist[start][mid] + dist[mid][end])
                        dist[start][end] = dist[start][end] + dist[mid][end];
                    if (dist[end][start] > dist[end][mid] + dist[mid][start])
                        dist[end][start] = dist[mid][end] + dist[mid][start];
                }
            }
        }

        int maxItems = 0;
        for (int node = 1; node < nodes + 1; node++) {
            int hereItems = 0;
            for (int next = 1; next < nodes + 1; next++) {
                if (dist[node][next] <= range) hereItems += items[next - 1];
            }
            maxItems = Math.max(maxItems, hereItems);
        }
        System.out.println(maxItems);
    }
}
