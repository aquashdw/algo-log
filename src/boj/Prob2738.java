package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// https://www.acmicpc.net/problem/2738
public class Prob2738 {
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] sizeTokens = reader.readLine().split(" ");
        int N = Integer.parseInt(sizeTokens[0]);
        int M = Integer.parseInt(sizeTokens[1]);

        int[][] operand = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] numTokens = reader.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                operand[i][j] = Integer.parseInt(numTokens[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            String[] numTokens = reader.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                operand[i][j] += Integer.parseInt(numTokens[j]);
            }
        }

        StringBuilder answerBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                answerBuilder.append(operand[i][j])
                        .append(" ");
            }
        }

        System.out.println(answerBuilder);
    }

    public static void main(String[] args) throws IOException {
        new Prob2738().solution();
    }
}
