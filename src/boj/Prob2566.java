package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2566
public class Prob2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[9][];
        for (int i = 0; i < 9; i++) {
            board[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int max = board[0][0];
        int x = 0;
        int y = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] > max) {
                    max = board[i][j];
                    x = j;
                    y = i;
                }
            }
        }
        StringBuilder answerBuilder = new StringBuilder();
        answerBuilder.append(max)
                .append('\n')
                .append(y + 1)
                .append(" ")
                .append(x + 1);
        System.out.println(answerBuilder);
    }
}
