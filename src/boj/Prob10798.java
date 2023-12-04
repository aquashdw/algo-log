package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/10798
public class Prob10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[][] letters = new char[5][];
        int maxLength = 0;
        for (int i = 0; i < 5; i++) {
            letters[i] = reader.readLine().toCharArray();
            maxLength = Math.max(letters[i].length, maxLength);
        }

        StringBuilder answerBuilder = new StringBuilder();
        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < 5; j++) {
                if (!(i < letters[j].length)) continue;
                answerBuilder.append(letters[j][i]);
            }
        }
        System.out.println(answerBuilder);
    }
}
