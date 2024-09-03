package boj;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/20098
public class Prob20098 {
    private static boolean[] visited;
    private static int n;
    private static int[][] sudoku;
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (BufferedReader reader = new BufferedReader(new FileReader("input/20098.in"))) {
            n = Integer.parseInt(reader.readLine());
            sudoku = new int[n * n][];
            visited = new boolean[n * n];
            for (int i = 0; i < n * n; i++) {
                sudoku[i] = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }
        }
//        dfs(0, 0);
        int offset = 0;
        for (int i = 0; i < n * n; i++) {
            if (i != 0 && i % 20 == 0) offset++;
            for (int j = 0; j < n * n; j++) {
                int next = j + offset;
                next += i * n;
                next %= n * n;
                next += 1;
                sudoku[i][j] = next;
            }
        }
        System.out.println(checkSudoku());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output/20098.out"))) {
            for (int[] row : sudoku) {
                System.out.println(Arrays.stream(row)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")));
                writer.write(Arrays.stream(row)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")));
                writer.newLine();
            }
        }
    }

    private static boolean checkSudoku() {
        for (int i = 0; i < n * n; i++) {
            for (int j = 0; j < n * n; j++) {
                if (!(checkCol(i) && checkRow(j) && checkSquare(i, j)))
                    return false;
            }
        }
        return true;
    }

    // 열 확인
    private static boolean checkCol(int col) {
        Arrays.fill(visited, false);
        for (int i = 0; i < n * n; i++) {
            if (sudoku[i][col] == 0) continue;
            if (visited[sudoku[i][col] - 1]) return false;
            visited[sudoku[i][col] - 1] = true;
        }
        return true;
    }

    // 행 확인
    private static boolean checkRow(int row) {
        Arrays.fill(visited, false);
        for (int i = 0; i < n * n; i++) {
            if (sudoku[row][i] == 0) continue;
            if (visited[sudoku[row][i] - 1]) return false;
            visited[sudoku[row][i] - 1] = true;
        }
        return true;
    }

    // 사각형 확인
    private static boolean checkSquare(int y, int x) {
        Arrays.fill(visited, false);
        int startY = (y / n) * n;
        int startX = (x / n) * n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sudoku[startY + i][startX + j] == 0) continue;
                if (visited[sudoku[startY + i][startX + j] - 1]) return false;
                visited[sudoku[startY + i][startX + j] - 1] = true;
            }
        }
        return true;
    }
}
