package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/25319
public class Prob25319 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int h = info[0];
        int w = info[1];
        int wordLength = info[2];

        char[][] board = new char[h][w];
        List<List<int[]>> positions = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            positions.add(new ArrayList<>());
        }
        for (int i = 0; i < h; i++) {
            String line = reader.readLine();
            for (int j = 0; j < w; j++) {
                positions.get(line.charAt(j) - 'a').add(new int[]{i, j});
                board[i][j] = line.charAt(j);
            }
        }
        String name = reader.readLine();
        int[] nameChars = new int[26];
        name.chars().forEach(c -> nameChars[c - 'a']++);

        StringBuilder path = new StringBuilder();
        int[] now = {0, 0};
        int count = 0;
        int move = 0;
        while (canMake(nameChars, positions)) {
            for (char c : name.toCharArray()) {
                int[] next = positions.get(c - 'a').remove(getClosePos(now, positions.get(c - 'a')));
                int diff = now[1] - next[1];
                if (diff != 0) {
                    path.append(diff > 0 ? "L".repeat(diff) : "R".repeat(-diff));
                    move += Math.abs(diff);
                }
                diff = now[0] - next[0];
                if (diff != 0) {
                    path.append(diff > 0 ? "U".repeat(diff) : "D".repeat(-diff));
                    move += Math.abs(diff);
                }
                path.append("P");
                now = next;
                move += 1;
            }
            count++;
        }

        int finDiff = now[1] - (w - 1);
        if (finDiff != 0) {
            path.append(finDiff > 0 ? "L".repeat(finDiff) : "R".repeat(-finDiff));
            move += Math.abs(finDiff);
        }
        finDiff = now[0] - (h - 1);
        if (finDiff != 0) {
            path.append(finDiff > 0 ? "U".repeat(finDiff) : "D".repeat(-finDiff));
            move += Math.abs(finDiff);
        }
        System.out.printf("%d %d%n%s%n", count, move, path);
    }

    private static int getClosePos(int[] now, List<int[]> points) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < points.size(); i++) {
            int[] point = points.get(i);
            int dist = Math.abs(point[0] - now[0]) + Math.abs(point[1] - now[1]);
            if (dist < min) {
                minIdx = i;
                min = dist;
            }
        }
        return minIdx;
    }

    private static boolean canMake(int[] nameChars, List<List<int[]>> positions) {
        return IntStream.range(0, 26).filter(i -> nameChars[i] > 0)
                .noneMatch(i -> positions.get(i).size() < nameChars[i]);
    }
}
