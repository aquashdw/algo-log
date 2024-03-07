package graph;

import java.io.IOException;
import java.util.*;

public class Maze {
    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};

    public void solution(int[][] maze) {
        Queue<int[]> visitNext = new LinkedList<>();
        boolean[][] visited = new boolean[6][6];
        visitNext.add(new int[]{5, 0, -1});
        int min = -1;
        while (!visitNext.isEmpty()) {
            int[] next = visitNext.poll();
            int nowX = next[0];
            int nowY = next[1];
            visited[nowX][nowY] = true;
            int steps = next[2];
            if (maze[next[0]][next[1]] == 3){
                min = next[2] + 1;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if (
                        checkBounds(nextX, nextY) &&
                        (maze[nextX][nextY] == 0 || maze[nextX][nextY] == 3) &&
                        !visited[nextX][nextY]
                ) {
                    visitNext.offer(new int[]{nextX, nextY, steps + 1});
                }
            }

        }
        System.out.println(min);
    }

    public boolean checkBounds(int x, int y) {
        return
                -1 < x && x < 6 &&
                -1 < y && y < 6;
    }

    public static void main(String[] args) throws IOException {
        new Maze().solution(new int[][]{
                {0, 0, 0, 0, 0, 3},
                {1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0, 0},
                {2, 1, 1, 0, 1, 1}
        });
    }
}
