package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.acmicpc.net/problem/25585
public class Prob25585 {
    private static final List<int[]> targets = new ArrayList<>();

    private static int minMoves = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] map = new int[n][];
        int[] start = {-1, -1};
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 2) {
                    start[0] = i;
                    start[1] = j;
                }
                if (map[i][j] == 1) {
                    targets.add(new int[]{i, j});
                }
            }
        }
        if (start[0] == -1) throw new IllegalArgumentException();
        if (targets.stream().anyMatch(target -> Math.abs(target[0] - start[0] + target[1] - start[1]) % 2 != 0)) {
            System.out.println("Shorei");
            return;
        }

        dfs(start, new boolean[n], 0, 0);
        System.out.printf("Undertaker%n%d%n", minMoves);
    }

    private static void dfs(int[] now, boolean[] visited, int count, int moves) {
        if (count == targets.size()) {
            minMoves = Math.min(minMoves, moves);
            return;
        }

        for (int i = 0; i < targets.size(); i++) {
            if (visited[i]) continue;
            int[] next = targets.get(i);
            int reqMoves = Math.max(Math.abs(now[0] - next[0]), Math.abs(now[1] - next[1]));
            if (moves + reqMoves > minMoves) continue;
            visited[i] = true;
            dfs(next, visited, count + 1, moves + reqMoves);
            visited[i] = false;
        }
    }

}
