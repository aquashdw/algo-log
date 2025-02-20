package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/11721
public class Prob11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int lf = 0;
        for (char letter : reader.readLine().toCharArray()) {
            if (lf == 10) {
                answer.append('\n');
                lf = 0;
            }
            answer.append(letter);
            lf += 1;
        }
        System.out.println(answer);
    }
}
