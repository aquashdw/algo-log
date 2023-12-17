package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// https://www.acmicpc.net/problem/12100
public class Prob12100 {
    private static int n;
    private static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        int[][] board = new int[n][];
        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        move(0, board, new int[5]);
        System.out.println(max);
    }

    public static void move(int depth, int[][] board, int[] log) {
        // 5번 왔다
        if (depth == 5) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] > max) {
                        max = board[i][j];
                    }
                }
            }
            return;
        }
        int[][] moved = new int[n][];
        for (int j = 0; j < n; j++) {
            moved[j] = Arrays.copyOf(board[j], n);
        }
        moveLeft(moved);
//        for (int[] row: moved) {
//            System.out.println(Arrays.toString(row));
//        }
        log[depth] = 0;
        move(depth + 1, moved, log);


        moved = new int[n][];
        for (int j = 0; j < n; j++) {
            moved[j] = Arrays.copyOf(board[j], n);
        }
        moveRight(moved);
//        for (int[] row: moved) {
//            System.out.println(Arrays.toString(row));
//        }
        log[depth] = 1;
        move(depth + 1, moved, log);

        moved = new int[n][];
        for (int j = 0; j < n; j++) {
            moved[j] = Arrays.copyOf(board[j], n);
        }
        transpose(moved);
        moveLeft(moved);
//        for (int[] row: moved) {
//            System.out.println(Arrays.toString(row));
//        }
        log[depth] = 2;
        move(depth + 1, moved, log);

        moved = new int[n][];
        for (int j = 0; j < n; j++) {
            moved[j] = Arrays.copyOf(board[j], n);
        }
        transpose(moved);
        moveRight(moved);
//        for (int[] row: moved) {
//            System.out.println(Arrays.toString(row));
//        }
        log[depth] = 3;
        move(depth + 1, moved, log);
    }

    public static void moveLeft(int[][] board) {
        for (int i = 0; i < n; i++) {
            int collide = 0;
            int[] row = board[i];
            for (int j = 0; j < n; j++) {
                if (row[j] == 0) continue;
                if (row[collide] == 0) {
                    row[collide] = row[j];
                    row[j] = 0;
                }
                else if (row[collide] == row[j]) {
                    if (collide == j) continue;
                    row[collide] *= 2;
                    row[j] = 0;
                    collide++;
                }
                else {
                    collide++;
                    row[collide] = row[j];
                    if (collide != j)
                        row[j] = 0;
                }
            }
        }
    }

    public static void moveRight(int[][] board) {
        for (int i = 0; i < n; i++) {
            int collide = n - 1;
            int[] row = board[i];
            for (int j = n - 1; j >= 0; j--) {
                // 이번 칸이 0이면 스킵
                if (row[j] == 0) continue;
                // 가장 오른쪽 끝이 0이면
                if (row[collide] == 0) {
                    // 현재 칸을 넣어주고
                    row[collide] = row[j];
                    // 현재 칸은 빈다.
                    row[j] = 0;
                    // 충돌 없이 이동했으므로 다음 충돌 판정도 collide에서 한다.
                }
                // 현재 충돌 판정 칸이랑 현재 칸의 값이 동일하다.
                else if (row[collide] == row[j]) {
                    // 근데 둘이 같은 칸이면 스킵
                    if (collide == j)
                        continue;
                    // 충돌되는 칸을 두배한다.
                    row[collide] *= 2;
                    // 현재 칸은 0
                    row[j] = 0;
                    // 이 칸은 더이상 충돌할 수 없다.
                    collide--;
                }
                // 다르다.
                else {
                    // 왼쪽 칸에 넣는다.
                    collide--;
                    row[collide] = row[j];
                    // 이동하지 못한게 아니면 0으로 채워준다.
                    if (collide != j)
                        row[j] = 0;
                }
            }
        }
    }

    public static void transpose(int[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = board[i][j];
                board[i][j] = board[j][i];
                board[j][i] = temp;
            }
        }
    }
}
