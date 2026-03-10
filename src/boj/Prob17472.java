package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/17472
public class Prob17472 {
    private static final int[][] deltas = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1},
    };
    private static int rows;
    private static int cols;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();


        rows = size[0];
        cols = size[1];
        int[][] map = new int[rows][];
        for (int i = 0; i < rows; i++) {
            map[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        boolean[][] visited = new boolean[rows][cols];

        // number the islands
        int islands = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j]) continue;
                visited[i][j] = true;
                if (map[i][j] == 0) continue;
                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{i, j});
                while (!queue.isEmpty()) {
                    int[] now = queue.poll();
                    map[now[0]][now[1]] = islands;
                    for (int[] delta : deltas) {
                        int nextY = now[0] + delta[0];
                        int nextX = now[1] + delta[1];
                        if (checkBounds(nextY, nextX) && !visited[nextY][nextX] && map[nextY][nextX] != 0) {
                            visited[nextY][nextX] = true;
                            queue.offer(new int[]{nextY, nextX});
                        }
                    }
                }
                islands++;
            }
        }

        // find shortest dists of islands
        int[][] dist = new int[islands][islands];
        Arrays.stream(dist).forEach(d -> Arrays.fill(d, 100));
        for (int i = 0; i < islands; i++) {
            dist[i][i] = 0;
        }

        for (int i = 0; i < rows; i++) {
            int lastMet = 0;
            int bridge = 0;
            for (int j = 0; j < cols; j++) {
                if (map[i][j] == 0) {
                    bridge++;
                    continue;
                }
                if (lastMet == map[i][j]) {
                    bridge = 0;
                    continue;
                }

                if (lastMet == 0) {
                    lastMet = map[i][j];
                    bridge = 0;
                    continue;
                }

                if (bridge > 1) {
                    int lastDist = dist[lastMet][map[i][j]];
                    dist[lastMet][map[i][j]] = Math.min(lastDist, bridge);
                    dist[map[i][j]][lastMet] = Math.min(lastDist, bridge);
                }
                lastMet = map[i][j];
                bridge = 0;
            }
        }

        for (int i = 0; i < cols; i++) {
            int lastMet = 0;
            int bridge = 0;
            for (int j = 0; j < rows; j++) {
                if (map[j][i] == 0) {
                    bridge++;
                    continue;
                }

                if (lastMet == map[j][i]) {
                    bridge = 0;
                    continue;
                }

                if (lastMet == 0) {
                    lastMet = map[j][i];
                    bridge = 0;
                    continue;
                }

                if (bridge > 1) {
                    int lastDist = dist[lastMet][map[j][i]];
                    dist[lastMet][map[j][i]] = Math.min(lastDist, bridge);
                    dist[map[j][i]][lastMet] = Math.min(lastDist, bridge);
                }
                lastMet = map[j][i];
                bridge = 0;
            }
        }

        boolean[] mst = new boolean[islands];
        mst[1] = true;
        int[] mstDist = Arrays.copyOf(dist[1], dist[1].length);
        int totalDist = 0;

        for (int i = 0; i < islands - 2; i++) {
            int minIdx = 0;
            for (int j = 1; j < islands; j++) {
                if (mst[j]) continue;
                if (mstDist[j] >= mstDist[minIdx]) continue;
                minIdx = j;
            }

            int next = minIdx;
            mst[next] = true;
            totalDist += mstDist[next];

            for (int j = 1; j < islands; j++) {
                if (mst[j]) continue;
                mstDist[j] = Math.min(mstDist[j], dist[next][j]);
            }
        }
        if (IntStream.range(1, mst.length).allMatch(i -> mst[i])) System.out.println(totalDist);
        else System.out.println(-1);
    }

    private static boolean checkBounds(int y, int x) {
        return y >= 0 && y < rows && x >= 0 && x < cols;
    }
}
/*
10 10
1 1 1 1 1 1 1 1 1 1
1 0 0 0 0 0 0 0 0 1
1 0 1 1 1 1 1 1 0 1
1 0 1 0 0 1 0 1 0 1
1 0 1 0 0 1 0 1 0 1
1 0 1 0 1 1 0 1 0 1
1 0 1 0 0 0 0 1 0 1
1 0 1 1 1 0 1 1 0 1
1 0 0 0 0 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1

6 6
1 1 1 1 1 1
1 0 0 0 0 0
1 0 1 1 0 0
1 0 0 0 0 0
1 0 0 0 0 0
1 1 1 1 1 1

 */