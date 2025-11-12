package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://www.acmicpc.net/problem/9870
public class Prob9870 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nmkq = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = nmkq[0];
        int m = nmkq[1];
        int hubs = nmkq[2];
        int q = nmkq[3];
        List<List<int[]>> adjList = new ArrayList<>(n);
        adjList.add(null);
        for (int i = 0; i < n; i++) {
            adjList.add(new LinkedList<>());
        }


        long[][] dist = new long[n + 1][n + 1];
        Arrays.stream(dist).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));
        for (int i = 1; i < n + 1; i++) {
            dist[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int[] edge = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            dist[edge[0]][edge[1]] = edge[2];
        }
        for (int mid = 1; mid < n + 1; mid++) {
            for (int start = 1; start < n + 1; start++) {
                for (int end = 1; end < n + 1; end++) {
                    if (dist[start][end] > dist[start][mid] + dist[mid][end])
                        dist[start][end] = dist[start][mid] + dist[mid][end];
                }
            }
        }

        int count = 0;
        long cost = 0;
        for (int i = 0; i < q; i++) {
            int[] plan = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            long[] hubDist = new long[hubs + 1];
            Arrays.fill(hubDist, Long.MAX_VALUE);
            for (int j = 1; j < hubs + 1; j++) {
                if (dist[plan[0]][j] == Integer.MAX_VALUE || dist[j][plan[1]] == Integer.MAX_VALUE) continue;
                hubDist[j] = dist[plan[0]][j] + dist[j][plan[1]];
            }
            long minDist = Arrays.stream(hubDist).min().orElseThrow();
            if (minDist == Long.MAX_VALUE) continue;
            count++;
            cost += minDist;
        }
        System.out.printf("%d%n%d%n", count, cost);
    }
}
