package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/16946
public class Prob16946 {
    private static int height;
    private static int width;
    private static final int[][] DELTAS = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] mapInfo = reader.readLine().split(" ");
        height = Integer.parseInt(mapInfo[0]);
        width = Integer.parseInt(mapInfo[1]);
        int[][] map = new int[height][];
        for (int i = 0; i < height; i++) {
            map[i] = reader.readLine().chars()
                    .map(intC -> intC - '0')
                    .toArray();
        }

        int[][] cells = new int[height][];
        for (int i = 0; i < height; i++) {
            cells[i] = Arrays.copyOf(map[i], width);
        }

        boolean[][] visited = new boolean[height][width];
        int label = 1;
        Map<Integer, Integer> cellsPerLabel = new HashMap<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (cells[i][j] == 1 || visited[i][j]) continue;
                Queue<int[]> toVisit = new LinkedList<>();
                Queue<int[]> toUpdate = new LinkedList<>();
                toVisit.offer(new int[]{i, j});
                int count = 0;
                while (!toVisit.isEmpty()) {
                    int[] now = toVisit.poll();
                    if (visited[now[0]][now[1]]) continue;
                    visited[now[0]][now[1]] = true;
                    count++;
                    toUpdate.offer(now);
                    for (int[] delta: DELTAS) {
                        int nextY = now[0] + delta[0];
                        int nextX = now[1] + delta[1];
                        if (checkBounds(nextY, nextX) && !visited[nextY][nextX] && map[nextY][nextX] == 0) {
                            toVisit.offer(new int[]{nextY, nextX});
                        }
                    }
                }

                while (!toUpdate.isEmpty()) {
                    int[] now = toUpdate.poll();
                    cells[now[0]][now[1]] = label;
                }

                cellsPerLabel.put(label, count);
                label++;
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (visited[i][j]) continue;
                cells[i][j] = 0;
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (cells[i][j] != 0) continue;
                int totalCells = 1;
                Set<Integer> selectedLabels = new HashSet<>();
                selectedLabels.add(0);
                for (int[] delta: DELTAS) {
                    int nextY = i + delta[0];
                    int nextX = j + delta[1];
                    if (checkBounds(nextY, nextX) && !selectedLabels.contains(cells[nextY][nextX])) {
                        totalCells += cellsPerLabel.get(cells[nextY][nextX]);
                        selectedLabels.add(cells[nextY][nextX]);
                    }
                }
                map[i][j] = totalCells % 10;
            }
        }
        for (int[] row: map) {
            System.out.println(Arrays.stream(row)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining("")));
        }
    }

    private static boolean checkBounds(int y, int x) {
        return 0 <= y && y < height &&
                0 <= x && x < width;
    }
}
