package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/16957
public class Prob16957 {
    private static int r;
    private static int c;
    private static final int[][] deltas = {
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] rc = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        r = rc[0];
        c = rc[1];
        int[][] board = new int[r][];
        for (int i = 0; i < r; i++) {
            board[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] balls = new int[r][c];
        for (int i = 0; i < r; i++) {
            Arrays.fill(balls[i], 1);
        }

        List<Integer> roots = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>(r * c);
        for (int i = 0; i < r * c; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int minInt = Integer.MAX_VALUE;
                int[] next = {-1, -1};
                for (int k = 0; k < 8; k++) {
                    int[] delta = deltas[k];
                    int nextY = i + delta[0];
                    int nextX = j + delta[1];
                    if (checkBounds(nextY, nextX) && board[nextY][nextX] < minInt) {
                        minInt = board[nextY][nextX];
                        next[0] = nextY;
                        next[1] = nextX;
                    }
                }
                if (minInt > board[i][j]) {
                    roots.add(i * c + j);
                    continue;
                }
                balls[i][j] = 0;
                adjList.get(next[0] * c + next[1]).add(i * c + j);
            }
        }

        for (int root : roots) {
            Queue<Integer> toVisit = new LinkedList<>(adjList.get(root));
            int addBalls = 0;
            while (!toVisit.isEmpty()) {
                int now = toVisit.poll();
                addBalls++;
                toVisit.addAll(adjList.get(now));
            }
            int y = root / c;
            int x = root - (y * c);
            balls[y][x] += addBalls;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < r; i++) {
            answer.append(Arrays.stream(balls[i]).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                    .append('\n');
        }
        System.out.print(answer);
    }

    private static boolean checkBounds(int y, int x) {
        return -1 < y && y < r && -1 < x &&  x < c;
    }
}
