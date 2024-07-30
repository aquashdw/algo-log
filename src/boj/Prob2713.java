package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/2713
public class Prob2713 {
    private static int r;
    private static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests)
                .forEach(line -> {
                    String[] testArgs = line.split(" ");
                    r = Integer.parseInt(testArgs[0]);
                    c = Integer.parseInt(testArgs[1]);
                    answer.append(makeMessage(testArgs)).append('\n');
                });
        System.out.println(answer);
    }

    private static int[][] deltas = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    private static String makeMessage(String[] msg) {
        String origin = Arrays.stream(msg).skip(2)
                .collect(Collectors.joining(" "));
        String binString = origin.chars()
                .map(ch -> ch == ' ' ? 0 : ch - 'A' + 1)
                .mapToObj(Integer::toBinaryString)
                .map(it -> String.format("%5s", it)
                        .replace(" ", "0"))
                .collect(Collectors.joining());

        char[][] matrix = new char[r][c];
        boolean[][] visited = new boolean[r][c];
        int dirIdx = 0;
        int[] now = {0, 0};
        for (int i = 0; i < r * c; i++) {
            char code = i < binString.length() ? binString.charAt(i) : '0';
            matrix[now[0]][now[1]] = code;
            visited[now[0]][now[1]] = true;
            if (
                    !checkBounds(now[0] + deltas[dirIdx][0], now[1] + deltas[dirIdx][1]) ||
                            visited[now[0] + deltas[dirIdx][0]][now[1] + deltas[dirIdx][1]]) {
                dirIdx = (dirIdx + 1) % 4;
            }
            now[0] += deltas[dirIdx][0];
            now[1] += deltas[dirIdx][1];
        }

        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                encrypted.append(matrix[i][j]);
            }
        }

        return encrypted.toString();
    }

    private static boolean checkBounds(int y, int x) {
        return -1 < y && y < r && -1 < x && x < c;
    }
}
