package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/10673
public class Prob10673 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] abn = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        long[][][] costs = new long[1001][1001][2];
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                Arrays.fill(costs[i][j], Long.MAX_VALUE);
            }
        }
        for (int i = 0; i < 1001; i++) {
            costs[i][i][0] = 0;
            costs[i][i][1] = 0;
        }

        for (int i = 0; i < abn[2]; i++) {
            long cost = Long.parseLong(reader.readLine().split(" ")[0]);
            int[] route = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < route.length; j++) {
                for (int k = j; k < route.length; k++) {
                    if (costs[route[j]][route[k]][0] > cost) {
                        costs[route[j]][route[k]][0] = cost;
                        costs[route[j]][route[k]][1] = k - j;
                    } else if (costs[route[j]][route[k]][0] == cost && costs[route[j]][route[k]][1] > k - j) {
                        costs[route[j]][route[k]][1] = k - j;
                    }
                }
            }
        }

        int start = abn[0];
        int goal = abn[1];

        long[][] dists = new long[1001][2];
        for (long[] dist : dists) {
            Arrays.fill(dist, Long.MAX_VALUE);
        }
        boolean[] visited = new boolean[1001];
        dists[start][0] = 0;
        dists[start][1] = 0;
        for (int i = 0; i < 1000; i++) {
            int next = -1;
            for (int j = 1; j < 1001; j++) {
                if (visited[j]) continue;
                if (next == -1 || (dists[j][0] < dists[next][0])) {

                    next = j;
                }
            }

            visited[next] = true;

            long[] toNext = dists[next];
            if (toNext[0] == Long.MAX_VALUE) continue;
            for (int j = 1; j < 1001; j++) {
                long[] dist = dists[j];
                if (costs[next][j][0] == Long.MAX_VALUE) continue;
                long[] newDist = {
                        toNext[0] + costs[next][j][0],
                        toNext[1] + costs[next][j][1]
                };
                if (dist[0] > newDist[0]) {
                    dist[0] = newDist[0];
                    dist[1] = newDist[1];
                } else if (dist[0] == newDist[0]) {
                    dist[1] = Math.min(dist[1], newDist[1]);
                }
            }
        }
        long[] dist = dists[goal];
        if (dist[0] == Long.MAX_VALUE) System.out.println("-1 -1");
        else System.out.printf("%d %d%n", dist[0], dist[1]);
    }
}
