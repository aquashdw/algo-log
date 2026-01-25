package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/5354
public class Prob5354 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).mapToInt(Integer::parseInt).forEach(n -> {
            answer.append("#".repeat(n)).append('\n');
            if (n == 1) {
                answer.append('\n');
                return;
            }
            for (int i = 0; i < n - 2; i++) {
                answer.append("#");
                answer.append("J".repeat(n - 2));
                answer.append("#\n");
            }
            answer.append("#".repeat(n)).append('\n');
            answer.append('\n');
        });
        System.out.print(answer);
    }
}
