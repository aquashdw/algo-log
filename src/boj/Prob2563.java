package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2563
public class Prob2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[][] board = new int[100][100];
        for (int i = 0; i < N; i++) {
            String[] leftUp = reader.readLine().split(" ");
            int startLeft = Integer.parseInt(leftUp[0]);
            int startUp = Integer.parseInt(leftUp[1]);
            for (int j = startLeft; j < startLeft + 10; j++) {
                for (int k = startUp; k < startUp + 10; k++) {
                    board[k][j] = 1;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                sum += board[i][j];
            }
        }
        System.out.println(sum);
    }
}
