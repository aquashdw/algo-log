package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/28280
public class Prob28280 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).mapToInt(Integer::parseInt)
                .forEach(k -> {
                    int count = 0;
                    while (k != 1) {
                        if (k % 2 == 0) {
                            k /= 2;
                        } else k++;
                        count++;
                    }
                    answer.append(count).append('\n');
                });
        System.out.print(answer);
    }
}
