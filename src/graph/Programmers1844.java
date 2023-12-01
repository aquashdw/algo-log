package graph;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers1844 {
    private int n;
    private int m;
    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};

    private boolean[][] visited;

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        return bfs(maps);
    }

    public int bfs(int[][] map) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});

        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            int steps = now[2];

            if (nowX == n - 1 && nowY == m - 1) {
                return steps;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if (
                        checkBounds(nextX, nextY) &&
                        map[nextX][nextY] == 1 &&
                        !visited[nextX][nextY]
                ) {
                    queue.add(new int[]{nextX, nextY, steps + 1});
                    visited[nextX][nextY] = true;
                }
            }
        }

        return -1;
    }

    public boolean checkBounds(int x, int y) {
        return
                -1 < x && x < n &&
                -1 < y && y < m;
    }

    public static void main(String[] args) {
        int answer = new Programmers1844().solution(new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        });
        System.out.println(answer);
    }
}
