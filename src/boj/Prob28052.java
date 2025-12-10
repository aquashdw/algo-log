package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/28052
public class Prob28052 {
    private static final int[][] deltas = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
    };
    private static int rows;
    private static int cols;
    private static int[][] bolt;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        int[] rc = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        rows = rc[0];
        cols = rc[1];

        int[] nutRaw = reader.readLine().chars().map(c -> c - '0').toArray();
        int[][] nuts = new int[2][];
        nuts[0] = IntStream.range(0, cols).filter(i -> nutRaw[i] == 1).toArray();
        nuts[1] = Arrays.stream(nuts[0]).map(i -> cols - i - 1).toArray();

        bolt = new int[rows][];
        for (int i = 0; i < rows; i++) {
            bolt[i] = reader.readLine().chars().map(c -> c - '0').toArray();
        }

        boolean[][][] visited = new boolean[rows][cols][2];
        Queue<int[]> toVisit = new LinkedList<>();
        for (int i = 0; i < cols; i++) {
            if (check(0, i, nuts[0])) {
                visited[0][i][0] = true;
                toVisit.add(new int[]{0, i, 0});
            }
            if (check(0, i, nuts[1])) {
                visited[0][i][0] = true;
                toVisit.add(new int[]{0, i, 1});
            }
        }

        boolean success = false;
        while (!toVisit.isEmpty()) {
            int[] now = toVisit.poll();
            if (now[0] == rows - 1) {
                success = true;
                break;
            }
            for (int[] delta : deltas) {
                int nextRow = now[0] + delta[0];
                int nextCol = (now[1] + delta[1] + cols) % cols;
                if (!check(nextRow, nextCol, nuts[now[2]]) || visited[nextRow][nextCol][now[2]]) continue;
                visited[nextRow][nextCol][now[2]] = true;
                toVisit.offer(new int[]{nextRow, nextCol, now[2]});
            }
        }
        System.out.println(success ? 'Y' : 'N');
    }

    private static boolean check(int level, int offset, int[] nut) {
        if (level < 0 || level > rows - 1) return false;
        return Arrays.stream(nut).map(i -> (i + offset) % cols).allMatch(i -> bolt[level][i] == 0);
    }


}
