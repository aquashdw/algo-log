package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// https://www.acmicpc.net/problem/3005
public class Prob3005 {
    private static char[][] board;
    private static int r;
    private static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] rc = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        r = rc[0];
        c = rc[1];
        board = new char[r][];
        for (int i = 0; i < r; i++) {
            board[i] = reader.readLine().toCharArray();
        }
        Queue<String> queue = new PriorityQueue<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == '#') continue;
                int upY = i - 1;
                int downY = i + 1;
                // 아래로 공간이 존재할 수 있다. (단어는 최소 두칸)
                if (i < r - 1) {
                    // 위가 벽, 아래는 뚫려있다.
                    if (upY < 0 && board[downY][j] != '#') queue.add(getYWord(i, j));
                    // 위가 막히고, 아래는 뚫려있다.
                    else if (upY >= 0 && board[upY][j] == '#' && board[downY][j] != '#') queue.add(getYWord(i, j));
                }

                int leftX = j - 1;
                int rightX = j + 1;
                // 오른쪽으로 공간이 존재할 수 있다. (단어는 최소 두칸)
                if (j < c - 1) {
                    // 왼쪽이 벽, 오른쪽은 뚫려있다.
                    if (leftX < 0 && board[i][rightX] != '#') queue.add(getXWord(i, j));
                    else if (leftX >= 0 && board[i][leftX] == '#' && board[i][rightX] != '#') queue.add(getXWord(i, j));
                }
            }
        }
        System.out.println(queue.peek());
    }

    private static String getYWord(int startY, int x) {
        StringBuilder word = new StringBuilder();
        int nowY = startY;
        while (nowY < r && board[nowY][x] != '#') {
            word.append(board[nowY][x]);
            nowY++;
        }
        return word.toString();
    }

    private static String getXWord(int y, int startX) {
        StringBuilder word = new StringBuilder();
        int nowX = startX;
        while (nowX < c && board[y][nowX] != '#') {
            word.append(board[y][nowX]);
            nowX++;
        }
        return word.toString();
    }
}
