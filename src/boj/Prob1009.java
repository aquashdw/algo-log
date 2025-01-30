package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1009
public class Prob1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).forEach(line -> {
            long[] test = Arrays.stream(line.split(" "))
                    .mapToLong(Long::parseLong).toArray();
            long jobs = test[0];
            if (jobs == 1) {
                answer.append(1).append('\n');
                return;
            }
            long sets = test[1];
            long computer = 1;
            for (int i = 0; i < sets; i++) {
                computer = (computer * jobs) % 10;
            }
            answer.append(computer == 0 ? 10 : computer).append('\n');
        });
        System.out.print(answer);
    }
}
