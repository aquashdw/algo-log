package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://www.acmicpc.net/problem/1238
public class Prob1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] baseInfo = reader.readLine().split(" ");
        // 정점: 학생수는 마을의 수와 같다.
        int students = Integer.parseInt(baseInfo[0]);
        // 간선: 도로
        int roads = Integer.parseInt(baseInfo[1]);
        // 도착지점, 이후엔 시작지점이 된다.
        int goal = Integer.parseInt(baseInfo[2]);

        int[][] adjMap = new int[students + 1][students + 1];
        for (int[] row : adjMap) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < roads; i++) {
            int[] roadInfo = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            adjMap[roadInfo[0]][roadInfo[1]] = roadInfo[2];
        }

        // 최댓값 저장
        int max = Integer.MIN_VALUE;
        // 각 학생들에 대하여 진행한다.
        for (int i = 1; i < students + 1; i++) {
            int[] dist = new int[students + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dijkstra(i, students, dist, adjMap);
            int iToGoal = dist[goal];

            Arrays.fill(dist, Integer.MAX_VALUE);
            dijkstra(goal, students, dist, adjMap);
            int goalToI = dist[i];
            max = Math.max(max, iToGoal + goalToI);
        }
        System.out.println(max);
    }
    /*
        public static void dijkstra(int start, int n, int[] dist, int[][] map) {
            boolean[] visited = new boolean[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[start] = 0;

            for (int j = 1; j < n + 1; j++) {
                int minDist = Integer.MAX_VALUE;
                int minDistNode = 0;
                for (int k = 1; k < n + 1; k++) {
                    if (!visited[k] && dist[k] < minDist) {
                        minDist = dist[k];
                        minDistNode = k;
                    }
                }

                visited[minDistNode] = true;

                for (int k = 1; k < n + 1; k++) {
                    if (map[minDistNode][k] == -1) continue;
                    int cost = map[minDistNode][k];
                    dist[k] = Math.min(dist[k], dist[minDistNode] + cost);
                }
            }
        }*/
    public static void dijkstra(int start, int n, int[] dist, int[][] map) {
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.offer(new int[]{start, 0});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (visited[now[0]]) continue;
            visited[now[0]] = true;

            for (int i = 1; i < n + 1; i++) {
                // 연결 안됨
                if (map[now[0]][i] == -1) continue;
                int nextCost = map[now[0]][i];
                if (dist[i] > dist[now[0]] + nextCost) {
                    dist[i] = dist[now[0]] + nextCost;
                    queue.offer(new int[]{i, dist[i]});
                }
            }
        }
    }
}
