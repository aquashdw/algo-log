package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/8848
public class Prob8848 {

    private static int[][] puzzle;
    private static int[][] pieces;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        n = size[0];
        m = size[1];
        puzzle = new int[n][m];
        pieces = new int[n * m + 1][];
        for (int i = 0; i < n * m; i++) {
            pieces[i + 1] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int[] firstTwo = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        puzzle[0][0] = firstTwo[0];
        puzzle[0][1] = firstTwo[1];
        boolean[] used = new boolean[n * m + 1];
        used[0] = true;
        used[puzzle[0][0]] = true;
        used[puzzle[0][1]] = true;
        if (!dfs(2, used)) {
            System.out.println("NIE");
            return;
        }

        System.out.print(Arrays.stream(puzzle)
                .map(row -> Arrays.stream(row)
                        .mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n")));
    }

    private static boolean dfs(int now, boolean[] used) {
        if (now == n * m) {
            return true;
        }

//        System.out.printf("%d %s%n", now, Arrays.deepToString(puzzle));

        int col = now % m;
        int row = now / m;
        if (row > 0 && col > 0) {
            int left = puzzle[row][col - 1];
            int up = puzzle[row - 1][col];
            int[] leftAdj = pieces[left];
            int[] upAdj = pieces[up];

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (leftAdj[i] != upAdj[j]) continue;
                    if (leftAdj[i] == 0 || upAdj[j] == 0) continue;
                    int piece = leftAdj[i];
                    if (used[piece]) continue;
                    puzzle[row][col] = piece;
                    used[piece] = true;
                    if (dfs(now + 1, used)) return true;
                    puzzle[row][col] = 0;
                    used[piece] = false;
                }
            }
        }
        // col == 0
        else if (row > 0) {
            int up = puzzle[row - 1][col];
            int[] upAdj = pieces[up];

            for (int piece : upAdj) {
                if (used[piece]) continue;
                int zeros = (int) Arrays.stream(pieces[piece])
                        .filter(i -> i == 0)
                        .count();
                if (zeros == 0) continue;
                if (row == n - 1 && zeros == 1) continue;
                puzzle[row][col] = piece;
                used[piece] = true;
                if (dfs(now + 1, used)) return true;
                puzzle[row][col] = 0;
                used[piece] = false;
            }
        }
        // row == 0
        else if (col > 0) {
            int left = puzzle[row][col - 1];
            int[] leftAdj = pieces[left];

            for (int piece : leftAdj) {
                if (used[piece]) continue;
                int zeros = (int) Arrays.stream(pieces[piece])
                        .filter(i -> i == 0)
                        .count();
                if (zeros == 0) continue;
                if (col == m - 1 && zeros == 1) continue;
                puzzle[row][col] = piece;
                used[piece] = true;
                if (dfs(now + 1, used)) return true;
                puzzle[row][col] = 0;
                used[piece] = false;
            }
        }
        return false;
    }

}
